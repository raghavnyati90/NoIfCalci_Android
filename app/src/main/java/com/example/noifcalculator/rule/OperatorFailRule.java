package com.example.noifcalculator.rule;

import com.example.noifcalculator.operations.IExpression;
import com.example.noifcalculator.operations.NumberExpression;
import com.example.noifcalculator.util.Util;

import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class OperatorFailRule implements IRule {

    String s;
    Character ch;
    Stack<Character> chStack = new Stack<Character>();
    Stack<IExpression> stack = new Stack<IExpression>();
    StringBuilder postfix;

    public OperatorFailRule(String s, Stack<IExpression> stack){
        this.s = s;
        this.stack = stack;
    }

    public OperatorFailRule(Character ch , Stack<Character> chStack, StringBuilder postfix){
        this.ch = ch;
        this.chStack = chStack;
        this.postfix = postfix;
    }

    public void evaluateCondition(String s, Stack<IExpression> stack){
        IExpression i = new NumberExpression(s);
        stack.push(i);
        //Util.operandOperation(s, stack);
    }

    public void convertCondition(Character ch, Stack<Character> stack, StringBuilder postfix){
        postfix.append(ch);
    }
}
