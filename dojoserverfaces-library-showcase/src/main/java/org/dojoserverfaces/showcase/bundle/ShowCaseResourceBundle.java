/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.bundle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ShowCaseResourceBundle extends ResourceBundle {
    private String[] taglibXmlFilePaths = { "META-INF/dojoserverfaces.taglib.xml" };
    private Map<String, String> descMap = new HashMap<String, String>();

    private static final String TAG_NODE = "tag";
    private static final String DESCRIPTION_NODE = "description";
    private static final String TAG_NAME_NODE = "tag-name";
    private static final String ATTRIBUTE_NODE = "attribute";
    private static final String NAME_NODE = "name";

    public ShowCaseResourceBundle() throws IOException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            for (String taglibXmlFilePath : taglibXmlFilePaths) {
                Enumeration<URL> enumer = Thread.currentThread()
                        .getContextClassLoader()
                        .getResources(taglibXmlFilePath);
                while (enumer.hasMoreElements()) {
                    Document doc = builder.parse(enumer.nextElement()
                            .openStream());
                    parse(doc);
                }
            }
        }

        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void parse(Document doc) {
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

    public String[] getTaglibXmlFilePaths() {
        return taglibXmlFilePaths;
    }

    public void setTaglibXmlFilePaths(String[] taglibXmlFilePaths) {
        this.taglibXmlFilePaths = taglibXmlFilePaths;
    }
}
