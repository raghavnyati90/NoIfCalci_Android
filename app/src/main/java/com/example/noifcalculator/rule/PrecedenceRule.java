package com.example.noifcalculator.rule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class PrecedenceRule {

    private final Map<Boolean, IPrecedenceRule> rules = new HashMap<Boolean, IPrecedenceRule>();

    public PrecedenceRule(){
        rules.put(true, new PrecedencePassRule());
        rules.put(false, new PrecedenceFailRule());
    }

    public IPrecedenceRule getExpressions(Boolean ch) {
        return rules.get(ch);
    }

}
