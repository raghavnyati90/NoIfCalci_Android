package com.example.noifcalculator.rule;

import java.util.Stack;

/**
 * Created by raghavnyati on 12/3/17.
 */

public interface IPrecedenceRule {
    void checkPrecedence(StringBuilder postfix, Stack<Character> stack);
}
