package com.smart.spel;

import com.smart.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

public class ObjectExprSample {
    public static void main(String[] args){
        ExpressionParser parser=new SpelExpressionParser();
        User user = parser.parseExpression("new com.smart.User(\"tom\")")
                .getValue(User.class);
        System.out.println(user.getUserName());
        EvaluationContext context = new StandardEvaluationContext();
        Map<String,Integer> creditsMap = new HashMap();
        creditsMap.put("Tom",95);
        creditsMap.put("Jony",110);
        creditsMap.put("Morin",85);
        creditsMap.put("Mose",120);
        context.setVariable("credits",creditsMap);
        Map<String,Integer> creditsGreater90 = (Map<String, Integer>) parser
                .parseExpression("#credits.?[value>90]").getValue(context);
        System.out.println(creditsGreater90.get("Jony"));

        List<Integer> credits = new ArrayList<Integer>();
        credits.addAll(Arrays.asList(150,100,90,50,110,130,70));
        context.setVariable("credits",credits);
        List<Boolean> creditsGreater100 = (List<Boolean>) parser.parseExpression("#credits.![#this>100]")
                .getValue(context);
        System.out.println(creditsGreater100.size());
        User<Integer> user1 = new User<Integer>(){
            public Integer initialValue(){
                return 0;
            }
        };
    }
}
