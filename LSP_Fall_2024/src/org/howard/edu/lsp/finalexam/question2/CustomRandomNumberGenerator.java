package org.howard.edu.lsp.finalexam.question2;

/**
 * Custom implementation of RandomNumberGenerator.
 */
public class CustomRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate() {
        // Custom algorithm for generating a random number
        long seed = System.currentTimeMillis();
        return (int) ((seed % Integer.MAX_VALUE) + 1); // Ensure positive numbers
    }
}
