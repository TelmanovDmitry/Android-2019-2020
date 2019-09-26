package com.example.itmo_android_2019_2020;


public abstract class UnarOper implements CommonExpression {
    CommonExpression expr;

    UnarOper(CommonExpression expr) {
        this.expr = expr;
    }

    @Override
    public int evaluate(int x) {
        return applyInSubclass(x);
    }

    @Override
    public double evaluate(double x) {
        return applyInSubclass(x);
    }

    protected abstract int applyInSubclass(int x);
    protected abstract double applyInSubclass(double x);
}
