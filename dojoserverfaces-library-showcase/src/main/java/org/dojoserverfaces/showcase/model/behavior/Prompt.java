/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
package org.dojoserverfaces.showcase.model.behavior;

import java.text.NumberFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Prompt {
    private static final char[] OPERATORS = { '+', '-', '*', '/' };

    private static final int OPERAND_RANGE = 100;
    
    private static final NumberFormat FORMATTER = NumberFormat.getNumberInstance();
    static {
        FORMATTER.setMaximumFractionDigits(2);
    }

    private double result;

    public String getMessage() {
        char operator = getNextOperator();
        int operandLeft = getNextOperand();
        int operandRight = getNextOperand();
        while (operator == '/' && operandRight == 0) {
            operandRight = getNextOperand();
        }
        result = eval(operator, operandLeft, operandRight);

        return new StringBuilder().append(operandLeft).append(" ")
                .append(operator).append(" ").append(operandRight).append("?")
                .toString();
    }

    private double eval(char oper, double x, double y) {
        switch (oper) {
        case '+':
            return x + y;
        case '-':
            return x - y;
        case '*':
            return x * y;
        case '/':
            return x / y;
        default:
            return 0;
        }
    }

    private char getNextOperator() {
        int idx = (int) (Math.random() * OPERATORS.length);
        return OPERATORS[idx];
    }

    private int getNextOperand() {
        return (int) (Math.random() * OPERAND_RANGE);
    }

    public String getResult() {
        return FORMATTER.format(result);
    }
}
