/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.widget.element;

import org.dojoserverfaces.constants.HtmlElementType;

public class ElementRendererFactory {

    public static HtmlElement getRenderer(HtmlElementType type) {
        switch (type) {
        case DIV:
            return divElement;

        case DIV_JSF_FORM:
            return divJsfFormElement;

        case DIV_AND_INPUT:
            return divAndInputElement;

        case SPAN:
            return spanElement;

        case ACTION:
            return actionElement;

        case INPUT_CHECKBOX:
            return inputCheckboxElement;

        case INPUT_RADIO:
            return inputRadioElement;

        case INPUT_TEXT:
            return inputTextElement;

        case INPUT_RANGE:
            return inputRangeElement;
        case INPUT_PASSWORD:
            return inputPasswordElement;

        case INPUT_TEXTAREA:
            return inputTextAreaElement;

        case SELECT:
            return selectElement;

        case SELECT_OPTION:
            return optionSelectElement;

        case TABLE:
            return tableElement;

        case MULTI_PART_FORM:
            return multiPartFormElement;
        }
        return null;
    }

    private static final String TEXTAREA = "textarea";
    private static final String PASSWORD = "password";
    private static final String RANGE = "range";
    private static final HtmlElement spanElement = new DivHtmlElement();
    private static final HtmlElement divElement = new DivHtmlElement();
    private static final HtmlElement divJsfFormElement = new DivJsfFormHtmlElement();
    private static final HtmlElement divAndInputElement = new DivAndInputHtmlElement();
    private static final HtmlElement actionElement = new ActionHtmlElement();
    private static final HtmlElement inputCheckboxElement = new CheckboxHtmlElement();
    private static final HtmlElement inputRadioElement = new RadioHtmlElement();
    private static final HtmlElement inputTextElement = new TextHtmlElement();
    private static final HtmlElement inputTextAreaElement = new InputHtmlElement(
            TEXTAREA);
    private static final HtmlElement inputPasswordElement = new InputHtmlElement(
            PASSWORD);
    private static final HtmlElement inputRangeElement = new InputHtmlElement(
            RANGE);
    private static final HtmlElement selectElement = new SelectHtmlElement();
    private static final HtmlElement optionSelectElement = new OptionSelectHtmlElement();
    private static final HtmlElement tableElement = new TableHtmlElement();
    private static final HtmlElement multiPartFormElement = new MultiPartFormHtmlElement();
}
