package com.example.noifcalculator.rule;

import com.example.noifcalculator.operations.IExpression;

import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public interface IRule {

    void evaluateCondition(String str, Stack<IExpression> stack);
    void convertCondition(Character s, Stack<Character> stack, StringBuilder postfix);
}
