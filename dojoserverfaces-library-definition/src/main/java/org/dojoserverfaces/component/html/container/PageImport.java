/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.component.html.container;

import org.dojoserverfaces.build.annotation.Container;
import org.dojoserverfaces.build.annotation.Property;

/**
 * An extended version of the ContentPane. Supports infile scripts and external
 * ones declared by <script src='' relative path adjustments (content fetched
 * from a different folder) <style> and <link rel='stylesheet' href='..'> tags,
 * css paths inside cssText is adjusted (if you set adjustPaths = true)
 * 
 * NOTE: dojo based content in the fetched file may not initialize properly.
 * Many widgets need to be initialized at page load to work properly.
 */
@Container(dojoType = "dojox.layout.ContentPane")
class PageImport extends ContentPane {

    /**
     * Adjust relative paths in html string content to point to this page. Only
     * useful if you grab content from a folder other then the current one.
     * Default is to not adjusts paths (false).
     */
    @Property
    Boolean adjustPaths;

    /**
     * cleans content to make it less likely to generate DOM/JS errors.
     * description: useful if you send ContentPane a complete page, instead of a
     * html fragment scans for and removes:
     *    title Node
     *    DOCTYPE tag 
     * Default is to not clean content
     * (false).
     */
    @Property
    Boolean cleanContent;

    /**
     * trigger/load styles in the content. Default is to not load styles
     * (false).
     */
    @Property
    Boolean renderStyles;

    /**
     * Execute (eval) scripts that is found in the content. Default is to
     * execute scripts (true).
     */
    @Property
    Boolean executeScripts;

    /**
     * replace keyword '_container_' in scripts with 'dijit.byId(this.id)'.
     * Default is to not replace hooks (false). NOTE this name might change in
     * the near future
     */
    @Property
    Boolean scriptHasHooks;
}