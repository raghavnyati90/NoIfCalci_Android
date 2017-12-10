package com.example.noifcalculator.operations;

/**
 * Created by raghavnyati on 12/3/17.
 */

public class NumberExpression implements IExpression {

    private final int number;

    public NumberExpression(int number){
        this.number = number;
    }

    public NumberExpression(String str){
        this.number = Integer.parseInt(str.toString());
    }

    @Override
    public int calculate(){
        return number;
    }

    @Override
    public String toString(){
        return number + "";
    }

}
