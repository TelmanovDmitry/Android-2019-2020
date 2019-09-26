package com.example.itmo_android_2019_2020;

public class Subtract extends BinOper {
    public Subtract(CommonExpression f, CommonExpression s) {
        super(f, s);
    }

    @Override
    protected int applyInSubclass(int x, int y) {
        return x - y;
    }

    @Override
    protected double applyInSubclass(double x, double y) {
        return x - y;
    }
}