package com.example.itmo_android_2019_2020;

public class Const implements CommonExpression {
    private final Double val;

    public Const(Double x) {
        val = x;
    }

    public double evaluate(Double x) {
        return val.doubleValue();
    }
}