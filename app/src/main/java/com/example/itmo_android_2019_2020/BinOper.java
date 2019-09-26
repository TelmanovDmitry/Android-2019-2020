package com.example.itmo_android_2019_2020;

public abstract class BinOper implements CommonExpression {
    protected CommonExpression l;
    protected CommonExpression r;

    public BinOper(CommonExpression f, CommonExpression s) {
        l = f;
        r = s;
    }

    @Override
    public int evaluate(int x) {
        return applyInSubclass(l.evaluate(x), r.evaluate(x));
    }

    @Override
    public double evaluate(double x) {
        return applyInSubclass(l.evaluate(x), r.evaluate(x));
    }

    protected abstract double applyInSubclass(double x, double y);
    protected abstract int applyInSubclass(int x, int y);
}