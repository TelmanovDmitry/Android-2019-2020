package com.example.itmo_android_2019_2020;


public abstract class UnarOper implements CommonExpression {
    CommonExpression expr;

    UnarOper(CommonExpression expr) {
        this.expr = expr;
    }

    @Override
    public double evaluate(Double x) {
        return applyInSubclass(x);
    }

    protected abstract double applyInSubclass(Double x);
}
