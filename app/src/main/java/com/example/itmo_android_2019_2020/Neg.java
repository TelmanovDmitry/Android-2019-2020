package com.example.itmo_android_2019_2020;

public class Neg extends UnarOper {
    public Neg(CommonExpression ex) {
        super(ex);
    }

    protected int applyInSubclass(int x) {
        return -x;
    }

    @Override
    protected double applyInSubclass(double x) {
        return -x;
    }
}
