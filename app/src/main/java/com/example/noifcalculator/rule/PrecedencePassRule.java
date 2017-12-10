package com.example.noifcalculator.rule;

import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class PrecedencePassRule implements IPrecedenceRule{

    public void checkPrecedence(StringBuilder postfix, Stack<Character> stack){
        postfix.append("A");
        postfix.append(stack.pop());
    }
}
