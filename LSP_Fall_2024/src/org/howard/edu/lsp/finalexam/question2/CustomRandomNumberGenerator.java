package org.howard.edu.lsp.finalexam.question2;

/**
 * Custom implementation of RandomNumberGenerator using a simple algorithm.
 */
public class CustomRandomNumberGenerator implements RandomNumberGenerator {
    private long seed = System.currentTimeMillis();

    @Override
    public int generateRandomNumber() {
        seed = (seed * 48271) % 2147483647; // LCG formula
        return (int) Math.abs(seed);
    }
}
