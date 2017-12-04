package com.ietree.base.concurrency;

public class EvenGenerator extends IntGenerator {
    private int currentEventValue = 0;

    @Override
    public int next() {
        ++currentEventValue;
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
