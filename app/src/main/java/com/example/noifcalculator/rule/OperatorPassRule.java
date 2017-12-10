package com.example.noifcalculator.rule;

import com.example.noifcalculator.operations.IExpression;
import com.example.noifcalculator.operations.NumberExpression;
import com.example.noifcalculator.util.Util;

import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class OperatorPassRule implements IRule {

    Character ch;
    String s;
    Stack<Character> chStack = new Stack<Character>();
    Stack<IExpression> stack = new Stack<IExpression>();
    StringBuilder postfix;

    public OperatorPassRule(String s, Stack<IExpression> stack){
        this.s = s;
        this.stack = stack;
    }

    public OperatorPassRule(Character ch , Stack<Character> chStack, StringBuilder postfix){
        this.ch = ch;
        this.chStack = chStack;
        this.postfix = postfix;
    }

    public void evaluateCondition(String s, Stack<IExpression> stack){
        IExpression right = stack.pop();
        IExpression left = stack.pop();
        IExpression operator = Util.getOperator(s, left, right);
        int result = operator.calculate();
        stack.push(new NumberExpression(result));
    }

    public void convertCondition(Character ch, Stack<Character> stack, StringBuilder postfix){
        //if () {
        IPrecedenceRule rule = new PrecedenceRule().getExpressions(Util.checkPrecedenceIfStackNotEmpty(stack, ch));
        rule.checkPrecedence(postfix, stack);
        //}
        stack.push(ch);
        postfix.append("A");
    }
}
