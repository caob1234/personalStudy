package com.smart.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class LiteralExprSample {
    public static void main(String[] args){
        ExpressionParser parser = new SpelExpressionParser();
        String helloWorld = (String) parser.parseExpression("\"Hello world\"").getValue();
        double doubleNumber = (double) parser.parseExpression("6.0221415E+23").getValue();
        int maxValue = (int) parser.parseExpression("0x7FFFFFFF").getValue();
        boolean trueValue = (boolean) parser.parseExpression("true").getValue();
        System.out.println(doubleNumber);
        System.out.println(maxValue);
    }
}
