package com.example.noifcalculator.util;

import com.example.noifcalculator.operations.AddExpression;
import com.example.noifcalculator.operations.DivideExpression;
import com.example.noifcalculator.operations.IExpression;
import com.example.noifcalculator.operations.MultiplyExpression;
import com.example.noifcalculator.operations.SubtractExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class Expression {

    private final Map<String, IExpression> expressions = new HashMap<String, IExpression>();

    public Expression(IExpression left, IExpression right){
        expressions.put("+", new AddExpression(left, right));
        expressions.put("-", new SubtractExpression(left, right));
        expressions.put("*", new MultiplyExpression(left, right));
        expressions.put("/", new DivideExpression(left, right));
    }

    public IExpression getExpressions(String ch) {
        return expressions.get(ch);
    }

    public boolean checkExpression(String ch){
        return expressions.containsKey(ch);
    }

}
