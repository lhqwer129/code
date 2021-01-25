package com.pattern.pattern.calculator.consts;

public enum OperationEnum {

    ADD{
        @Override
        public int caculate(int a, int b) {
            return a + b;
        }
    },

    SUBSTRACT{
        @Override
        public int caculate(int a, int b) {
            return a - b;
        }
    };

    protected abstract int caculate(int a, int b);

}
