package com.example.itmo_android_2019_2020;

public class Neg extends UnarOper {
    public Neg(CommonExpression ex) {
        super(ex);
    }

    @Override
    protected double applyInSubclass(Double x) {
        return -x;
    }
}
