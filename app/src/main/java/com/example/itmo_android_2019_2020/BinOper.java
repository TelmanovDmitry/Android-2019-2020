package com.example.itmo_android_2019_2020;

public abstract class BinOper implements CommonExpression {
    protected CommonExpression l;
    protected CommonExpression r;

    public BinOper(CommonExpression f, CommonExpression s) {
        l = f;
        r = s;
    }

    @Override
    public double evaluate(Double x) {
        return applyInSubclass(l.evaluate(x), r.evaluate(x));
    }

    protected abstract double applyInSubclass(Double x, Double y);
}