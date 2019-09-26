package com.example.itmo_android_2019_2020;

public class Multiply extends BinOper {
    public Multiply(CommonExpression f, CommonExpression s) {
        super(f, s);
    }

    @Override
    protected int applyInSubclass(int x, int y) {
        return x * y;
    }

    @Override
    protected double applyInSubclass(double x, double y) {
        return x * y;
    }
}
