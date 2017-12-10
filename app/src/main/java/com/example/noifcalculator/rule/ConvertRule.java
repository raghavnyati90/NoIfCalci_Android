package com.example.noifcalculator.rule;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class ConvertRule {

    private final Map<Boolean, IRule> rules = new HashMap<Boolean, IRule>();

    public ConvertRule(Character ch, Stack<Character> stack, StringBuilder postfix){
        rules.put(true, new OperatorPassRule(ch, stack, postfix));
        rules.put(false, new OperatorFailRule(ch, stack, postfix));
    }

    public IRule getExpressions(Boolean ch) {
        return rules.get(ch);
    }
}
