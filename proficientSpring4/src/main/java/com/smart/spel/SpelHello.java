package com.smart.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpelHello {
    public static void main(String[] args)throws Exception{
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello'+' world'");
        String message = (String) expression.getValue();
        System.out.println(message);
    }
}
