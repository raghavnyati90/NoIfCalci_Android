package com.example.noifcalculator.operations;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class SubtractExpression implements IExpression {

    private final IExpression lExpr, rExpr;

    public SubtractExpression(IExpression lExpr, IExpression rExpr){
        this.lExpr = lExpr;
        this.rExpr = rExpr;
    }

    @Override
    public int calculate(){
        return lExpr.calculate() - rExpr.calculate();
    }

    @Override
    public String toString(){
        return lExpr.toString() + " - " + rExpr.toString();
    }
}