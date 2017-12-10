package com.example.noifcalculator.util;

import com.example.noifcalculator.operations.IExpression;
import com.example.noifcalculator.operations.NumberExpression;
import com.example.noifcalculator.rule.ConvertRule;
import com.example.noifcalculator.rule.EvaluateRule;
import com.example.noifcalculator.rule.IRule;

import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class Util {

    public static boolean isOperator(Character str){
        return str.equals('+') || str.equals('-') || str.equals('*') || str.equals('/');
    }

    public static IExpression getOperator(String ch, IExpression left, IExpression right){
        return new Expression(left, right).getExpressions(ch);
    }

    private static int getPrecedence(char ch) {
        return new Precedence().getOperatorPrecedence(ch);
    }

    public static boolean checkPrecedenceIfStackNotEmpty(Stack<Character> stack, Character ch){
        return !stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek());
    }

    public static String convertToPostfix(String infix) {
        
        Stack<Character> stack = new Stack<Character>();
        StringBuilder postfix = new StringBuilder(infix.length());
        
        Character ch;
        for (int i = 0; i < infix.length(); i++) {
            ch = infix.charAt(i);

            IRule rule = new ConvertRule(ch, stack, postfix).getExpressions(isOperator(ch));
            rule.convertCondition(ch, stack, postfix);
        }

        while (!stack.isEmpty()) {
            postfix.append("A");
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static String evaluateExpression(String infixText) {

        String mInputText = Util.convertToPostfix(infixText.replaceAll(" ", "")).replaceAll(" ","");;

        Stack<IExpression> stack = new Stack<IExpression>();

        String [] tokens = mInputText.split("[A]");

        for(String s: tokens){
            IRule rule = new EvaluateRule(s, stack).getExpressions(isOperator(s.charAt(0)));
            rule.evaluateCondition(s, stack);
        }
        return stack.pop().toString();
    }

}
