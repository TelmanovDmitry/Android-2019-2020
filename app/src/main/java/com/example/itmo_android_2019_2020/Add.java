package com.example.itmo_android_2019_2020;

public class Add extends BinOper {
    public Add(CommonExpression f, CommonExpression s) {
        super(f, s);
    }

    @Override
    protected double applyInSubclass(Double x, Double y) {
        return x + y;
    }
}