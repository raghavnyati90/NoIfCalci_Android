package com.example.noifcalculator.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class Precedence {

    private final Map<Character, Integer> operatorPrecedence = new HashMap<Character, Integer>();

    public Precedence(){
        operatorPrecedence.put('+', 1);
        operatorPrecedence.put('-', 1);
        operatorPrecedence.put('*', 2);
        operatorPrecedence.put('/', 2);
        operatorPrecedence.put(' ', -1);
    }

    public Integer getOperatorPrecedence(Character ch) {
        return operatorPrecedence.get(ch);
    }
}
