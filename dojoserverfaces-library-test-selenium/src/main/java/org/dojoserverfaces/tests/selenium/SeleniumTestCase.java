/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.tests.selenium;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.dojoserverfaces.tests.widget.interaction.WidgetInteraction;
import junit.framework.AssertionFailedError;

import com.thoughtworks.selenium.SeleneseTestCase;

/**
 * This class extends SeleneseTestCase class and adds few additional functions
 * like waitForXXX, along verifyXXX functions which include message hint.
 * 
 * @author "jatin.varshney@in.ibm.com"
 * 
 */
public abstract class SeleniumTestCase extends SeleneseTestCase {

    protected StringBuffer verificationErrors = new StringBuffer();
    protected WidgetInteraction widgetInteraction;

    protected int DEFAULT_WAIT_PERIOD = 2; // 2 seconds , for ajax calls
    protected String PAGE_LOAD_TIMEOUT = "20000"; // 20 seconds
    protected int PAGE_READY_TIMEOUT = 500 // 0.5 second
    ;

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for an element to present
     * 
     * @param element
     *            - element id like "form:input"
     */
    public void waitForExistence(String element) {
        waitForExistence("", element, DEFAULT_WAIT_PERIOD);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for an element to present
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param element
     *            - element id like "form:input"
     */
    public void waitForExistence(String message, String element) {
        waitForExistence(message, element, DEFAULT_WAIT_PERIOD);
    }

    /**
     * Wait for specified number of seconds for an element to present
     * 
     * @param element
     *            - element id like "form:input"
     * @param seconds
     *            - maximum number of seconds to wait for the condition to be
     *            true
     */
    public void waitForExistence(String element, int seconds) {
        waitForExistence("", element, seconds);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for an element to present
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param element
     *            - element id like "form:input"
     * @param seconds
     *            - maximum number of seconds to wait for the condition to be
     *            true
     */
    public void waitForExistence(String message, String element, int seconds) {
        for (int second = 0;; second++) {
            if (second >= seconds) {
                try {
                    message = formattedMessage(message);
                    fail(message + "Timeout: the element: " + element
                            + " could not be found");
                }
                catch (Error e) {
                    this.verificationErrors.append(throwableToString(e));
                    break;
                }
            }
            try {
                if (selenium.isElementPresent(element))
                    break;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its text
     * 
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     */
    public void waitForTextToChange(String newValue, String element) {
        waitForTextToChange(newValue, element, DEFAULT_WAIT_PERIOD);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its text
     * 
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     * @param seconds
     *            - maximum number of seconds to wait for the condition to be
     *            true
     */
    public void waitForTextToChange(String newValue, String element, int seconds) {
        waitForTextToChange("", newValue, element, seconds);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its text
     * 
     * @param message
     *            - message hint in case of assertion failure - message hint in
     *            case of assertion failure
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     */
    public void waitForTextToChange(String message, String newValue,
            String element) {
        waitForTextToChange(message, newValue, element, DEFAULT_WAIT_PERIOD);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its text
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     * @param seconds
     *            - maximum number of seconds to wait for the condition to be
     *            true
     */
    public void waitForTextToChange(String message, String newValue,
            String element, int seconds) {
        for (int second = 0;; second++) {
            if (second >= seconds) {
                try {
                    message = formattedMessage(message);
                    fail(message + "Timeout: the element: " + element
                            + " could not change its text to " + newValue);
                }
                catch (Error e) {
                    this.verificationErrors.append(throwableToString(e));
                    break;
                }
            }
            try {
                if (newValue.equals(selenium.getText(element)))
                    break;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its value
     * 
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     */
    public void waitForValueToChange(String newValue, String element) {
        waitForValueToChange(newValue, element, DEFAULT_WAIT_PERIOD);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its value
     * 
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     * @param seconds
     *            - maximum number of seconds to wait for the condition to be
     *            true
     */
    public void waitForValueToChange(String newValue, String element,
            int seconds) {
        waitForValueToChange("", newValue, element, seconds);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its value
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     */
    public void waitForValueToChange(String message, String newValue,
            String element) {
        waitForValueToChange(message, newValue, element, DEFAULT_WAIT_PERIOD);
    }

    /**
     * Wait for DEFAULT_WAIT_PERIOD seconds for some element to change its value
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param newValue
     *            - the value which the element expects to change
     * @param element
     *            - element id like "form:input"
     * @param seconds
     *            - maximum number of seconds to wait for the condition to be
     *            true
     */
    public void waitForValueToChange(String message, String newValue,
            String element, int seconds) {
        for (int second = 0;; second++) {
            if (second >= seconds) {
                try {
                    message = formattedMessage(message);
                    fail(message + "Timeout: the element: " + element
                            + " could not change its text to " + newValue);
                }
                catch (Error e) {
                    this.verificationErrors.append(throwableToString(e));
                    break;
                }
            }
            try {
                if (newValue.equals(widgetInteraction
                        .getDisplayedValue(element)))
                    break;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public static void assertEquals(String message, Object s1, Object s2) {
        if ((s1 instanceof String) && (s2 instanceof String)) {
            assertEquals(message, (String) s1, (String) s2);
        }
        else if ((s1 instanceof String) && (s2 instanceof String[])) {
            assertEquals(message, (String) s1, (String[]) (String[]) s2);
        }
        else if ((s1 instanceof String) && (s2 instanceof Number)) {
            assertEquals(message, (String) s1, ((Number) s2).toString());
        }
        else {
            if ((!(s1 instanceof String[])) || (!(s2 instanceof String[])))
                return;
            String[] sa1 = (String[]) (String[]) s1;
            String[] sa2 = (String[]) (String[]) s2;
            if (sa1.length != sa2.length) {
                message = formattedMessage(message);
                throw new Error(message + "Expected " + sa1 + " but saw " + sa2);
            }
            for (int j = 0; j < sa1.length; ++j)
                assertEquals(message, sa1[j], sa2[j]);
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public static void assertEquals(String message, String s1, String s2) {
        message = formattedMessage(message);
        assertTrue(message + "Expected \"" + s1 + "\" but saw \"" + s2
                + "\" instead", seleniumEquals(s1, s2));
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public static void assertEquals(String message, String s1, String[] s2) {
        assertEquals(message, s1, joinStrArray(s2, ','));
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public static void assertEquals(String message, String[] s1, String[] s2) {
        String comparisonDumpIfNotEqual = verifyEqualsAndReturnComparisonDumpIfNot(
                message, s1, s2);
        if (comparisonDumpIfNotEqual != null)
            throw new AssertionError(comparisonDumpIfNotEqual);
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param b1
     * @param b2
     */
    public static void assertNotEquals(String message, boolean b1, boolean b2) {
        assertNotEquals(message, new Boolean(b1), new Boolean(b2));
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param obj1
     * @param obj2
     */
    public static void assertNotEquals(String message, Object obj1, Object obj2) {
        if (obj1.equals(obj2)) {
            message = formattedMessage(message);
            fail(message + "did not expect values to be equal ("
                    + obj1.toString() + ")");
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @return
     */
    private static String formattedMessage(String message) {
        if (null == message)
            message = "";
        if (message.equals(""))
            return message;
        return message + " , ";
    }

    /**
     * 
     * @param sa
     * @param c
     * @return
     */
    public static String joinStrArray(String[] sa, char c) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < sa.length; ++j) {
            sb.append(sa[j]);
            if (j < sa.length - 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String stringArrayToString(String[] sa) {
        StringBuffer sb = new StringBuffer("{");
        for (int j = 0; j < sa.length; ++j) {
            sb.append(" ").append("\"").append(sa[j]).append("\"");
        }

        sb.append(" }");
        return sb.toString();
    }

    private static String throwableToString(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    private static String verifyEqualsAndReturnComparisonDumpIfNot(
            String message, String[] s1, String[] s2) {
        boolean misMatch = false;
        if (s1.length != s2.length) {
            misMatch = true;
        }
        for (int j = 0; j < s1.length; ++j) {
            if (!seleniumEquals(s1[j], s2[j])) {
                misMatch = true;
                break;
            }
        }
        if (misMatch) {
            message = formattedMessage(message);
            return message + "Expected " + stringArrayToString(s1)
                    + " but saw " + stringArrayToString(s2);
        }
        return null;
    }

    public void checkItsVerificationErrors() {
        String verificationErrorString = this.verificationErrors.toString();
        clearItsVerificationErrors();
        if (!"".equals(verificationErrorString))
            fail(verificationErrorString);
    }

    public void clearItsVerificationErrors() {
        this.verificationErrors = new StringBuffer();
    }

    public void tearDown() throws Exception {
        checkItsVerificationErrors();
        super.tearDown();
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public void verifyEquals(String message, Object s1, Object s2) {
        try {
            assertEquals(message, s1, s2);
        }
        catch (Error e) {
            this.verificationErrors.append(throwableToString(e));
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public void verifyEquals(String message, String[] s1, String[] s2) {
        String comparisonDumpIfNotEqual = verifyEqualsAndReturnComparisonDumpIfNot(
                message, s1, s2);
        if (comparisonDumpIfNotEqual != null)
            this.verificationErrors.append(comparisonDumpIfNotEqual);
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param b
     */
    public void verifyFalse(String message, boolean b) {
        try {
            assertFalse(message, b);
        }
        catch (Error e) {
            this.verificationErrors.append(throwableToString(e));
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public void verifyNotEquals(String message, boolean s1, boolean s2) {
        try {
            assertNotEquals(message, new Boolean(s1), new Boolean(s2));
        }
        catch (AssertionFailedError e) {
            this.verificationErrors.append(throwableToString(e));
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param s1
     * @param s2
     */
    public void verifyNotEquals(String message, Object s1, Object s2) {
        try {
            assertNotEquals(message, s1, s2);
        }
        catch (AssertionFailedError e) {
            this.verificationErrors.append(throwableToString(e));
        }
    }

    /**
     * 
     * @param message
     *            - message hint in case of assertion failure
     * @param b
     */
    public void verifyTrue(String message, boolean b) {
        try {
            assertTrue(message, b);
        }
        catch (Error e) {
            this.verificationErrors.append(throwableToString(e));
        }
    }

    /**
     * Clicks on the button with id <code>elementId</code>, and waits for page
     * to load and dojo to be ready
     * 
     * @param elementId
     *            - id of the button.
     */
    public void clickAndwaitForPageLoad(String elementId) {
        selenium.click(elementId);
        int i = 0;
        while (i < 5 && waitForPageLoadAndDojoReady(elementId))
            i++;
    }

    /**
     * Waits for page load, and dojo to be ready, and if dojo is not ready, it
     * clicks the button with <code>elementId</code> again
     * 
     * @param elementId
     * @return
     */
    private boolean waitForPageLoadAndDojoReady(String elementId) {
        selenium.waitForPageToLoad(PAGE_LOAD_TIMEOUT);
        try {
            Thread.sleep(PAGE_READY_TIMEOUT);
            if (isDojoLoaded(false)) {
                return false;
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        selenium.click(elementId);
        return true;
    }

    /**
     * Refreshes the page at max 5 times and waits for dojo to be ready.
     */
    public void waitForDojoReady() {
        int i = 0;
        while (i < 5 && !isDojoLoaded(true)) {
            selenium.refresh();
            i++;
            try {
                Thread.sleep(PAGE_READY_TIMEOUT);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Test to see if the dojo is has been loaded and is ready in the document.
     * 
     * @return
     */
    public boolean isDojoLoaded(boolean b) {
        System.out.println(b + " " + selenium.getEval("window.dijit"));
        return !"null".equals(selenium.getEval("window.dijit"));
    }
}