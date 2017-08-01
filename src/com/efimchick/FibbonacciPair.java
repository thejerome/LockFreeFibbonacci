package com.efimchick;

import java.math.BigInteger;

/**
 * Created by efimchick on 01.08.17.
 */


public class FibbonacciPair {
    private final BigInteger previous;
    private final BigInteger current;

    public FibbonacciPair(BigInteger previous, BigInteger current) {
        this.previous = previous;
        this.current = current;
    }

    public FibbonacciPair next() {
        return new FibbonacciPair(current, previous.add(current));
    }

    public BigInteger getCurrent() {
        return current;
    }
}
