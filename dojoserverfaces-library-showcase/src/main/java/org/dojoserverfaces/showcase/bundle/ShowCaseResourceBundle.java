/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ShowCaseResourceBundle extends ResourceBundle {
    private String taglibXmlFilePath;
    private Map<String, String> descMap = new HashMap<String, String>();

    private static final String TAG_NODE = "tag";
    private static final String DESCRIPTION_NODE = "description";
    private static final String TAG_NAME_NODE = "tag-name";
    private static final String ATTRIBUTE_NODE = "attribute";
    private static final String NAME_NODE = "name";
    
    // TODO: I moved this here because doing this via the servlet wasn't working
    // correctly (just getting nulls and such).  Why would you even use a servlet to
    // initialize this when a constructor works just fine?
    
    public ShowCaseResourceBundle () {
    	setTaglibXmlFilePath ("/META-INF/dojoserverfaces.taglib.xml");
    	
    	try {
    		init();
    	}
    	
    	catch (Throwable e) {
    		e.printStackTrace();
    	}
    }
    
    public void init() throws ParserConfigurationException, SAXException,
            IOException {
        InputStream taglibFileInStream = getClass().getResourceAsStream(
                taglibXmlFilePath);
        if (taglibFileInStream == null) {
            System.err
                    .println("[JDShowCaseResourceBundle.init]: taglibXmlFile not found! taglibXmlFilePath="
                            + taglibXmlFilePath);
            return;
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(taglibFileInStream);

        NodeList tagNL = doc.getElementsByTagName(TAG_NODE);
        for (int i = 0; i < tagNL.getLength(); i++) {
            Node tagNode = tagNL.item(i);
            Node descNode = getChild(tagNode, DESCRIPTION_NODE);
            Node tagNameNode = getChild(tagNode, TAG_NAME_NODE);
            String tagName = tagNameNode.getTextContent();
            descMap.put(tagKey(tagName), descNode.getTextContent());

            // attrNames -> all attributes of this tag separated by space.
            StringBuilder attrNames = new StringBuilder();
            List<Node> attributeNodes = getChildren(tagNode, ATTRIBUTE_NODE);
            for (Node attrNode : attributeNodes) {
                Node attrDescNode = getChild(attrNode, DESCRIPTION_NODE);
                Node attrNameNode = getChild(attrNode, NAME_NODE);
                descMap.put(attrKey(tagName, attrNameNode.getTextContent()),
                        attrDescNode.getTextContent());

                if (attrNames.length() > 0)
                    attrNames.append(" ");
                attrNames.append(attrNameNode.getTextContent());
            }
            descMap.put(attrKey(tagName, null), attrNames.toString());
        }
    }

    private Node getChild(Node parent, String childName) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            String name = children.item(i).getNodeName();
            if (name.equals(childName)) {
                return children.item(i);
            }
        }
        return null;
    }

    private List<Node> getChildren(Node parent, String childName) {
        List<Node> result = new ArrayList<Node>();

        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            String name = children.item(i).getNodeName();
            if (name.equals(childName)) {
                result.add(children.item(i));
            }
        }

        return result;
    }

    private String tagKey(String tagName) {
        return new StringBuilder("tag_").append(tagName).toString();
    }

    private String attrKey(String tagName, String attrName) {
        if (attrName == null || attrName.length() == 0) {
            // This is the "all attribute" key, will this key conflict with
            // other attribute name of this tag?
            attrName = "attributes";
        }
        return new StringBuilder("tag_").append(tagName).append("_")
                .append(attrName).toString();
    }

    @Override
    public Enumeration<String> getKeys() {
        final Iterator<String> keys = descMap.keySet().iterator();
        return new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return keys.hasNext();
            }

            @Override
            public String nextElement() {
                return keys.next();
            }
        };
    }

    @Override
    protected Object handleGetObject(String key) {
        return descMap.get(key);
    }

    public String getTaglibXmlFilePath() {
        return taglibXmlFilePath;
    }

    public void setTaglibXmlFilePath(String taglibXmlFilePath) {
        this.taglibXmlFilePath = taglibXmlFilePath;
    }
}
