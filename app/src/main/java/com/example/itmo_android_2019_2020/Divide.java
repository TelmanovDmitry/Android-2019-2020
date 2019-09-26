package com.example.itmo_android_2019_2020;

public class Divide extends BinOper {
    public Divide(CommonExpression f, CommonExpression s) {
        super(f, s);
    }

    @Override
    protected double applyInSubclass(Double x, Double y) {
        return x / y;
    }
}