package org.howard.edu.lsp.finalexam.question2;

/**
 * Singleton service class for managing random number generation.
 */
public class RandomNumberService {
    private static RandomNumberService instance;
    private RandomNumberGenerator generator;

    private RandomNumberService() {}

    // Singleton instance getter
    public static RandomNumberService getInstance() {
        if (instance == null) {
            instance = new RandomNumberService();
        }
        return instance;
    }

    // Set the random number generator strategy
    public void setGenerator(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    // Generate a random number using the current strategy
    public int getRandomNumber() {
        if (generator == null) {
            throw new IllegalStateException("Random number generator is not set");
        }
        return generator.generate();
    }
}
