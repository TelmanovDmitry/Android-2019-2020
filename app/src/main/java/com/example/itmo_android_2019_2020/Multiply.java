package com.example.itmo_android_2019_2020;

public class Multiply extends BinOper {
    public Multiply(CommonExpression f, CommonExpression s) {
        super(f, s);
    }

    @Override
    protected double applyInSubclass(Double x, Double y) {
        return x * y;
    }
}
