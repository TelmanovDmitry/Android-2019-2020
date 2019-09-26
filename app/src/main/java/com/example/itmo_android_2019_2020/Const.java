package com.example.itmo_android_2019_2020;

public class Const implements CommonExpression {
    private final Number val;

    public Const(Number x) {
        val = x;
    }

    public double evaluate(double x) {
        return val.doubleValue();
    }

    public int evaluate(int x) {
        return val.intValue();
    }
}