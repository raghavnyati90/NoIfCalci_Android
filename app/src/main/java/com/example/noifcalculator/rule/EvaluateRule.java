package com.example.noifcalculator.rule;

import com.example.noifcalculator.operations.IExpression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */


public class EvaluateRule {

    private final Map<Boolean, IRule> rules = new HashMap<Boolean, IRule>();

    public EvaluateRule(String s, Stack<IExpression> stack){
            rules.put(true, new OperatorPassRule(s, stack));
            rules.put(false, new OperatorFailRule(s, stack));
    }

    public IRule getExpressions(Boolean ch) {
        return rules.get(ch);
    }
}