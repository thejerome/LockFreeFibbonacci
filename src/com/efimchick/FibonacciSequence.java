package com.efimchick;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by efimchick on 01.08.17.
 */
public class FibonacciSequence {

    private final AtomicReference<FibbonacciPair> current;

    public FibonacciSequence() {
        this.current = new AtomicReference<>(new FibbonacciPair(BigInteger.ZERO, BigInteger.ONE));
    }

    public BigInteger next(){
        final FibbonacciPair pair = current.updateAndGet(FibbonacciPair::next);
        return pair.getCurrent();
    }
}
