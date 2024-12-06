package org.howard.edu.lsp.finalexam.question2;

/**
 * Singleton service for generating random numbers using different strategies.
 */
public class RandomNumberService {
    private static RandomNumberService instance;

    private RandomNumberGenerator generator;

    /**
     * Private constructor to prevent instantiation.
     */
    private RandomNumberService() {}

    /**
     * Retrieves the singleton instance of RandomNumberService.
     * @return the singleton instance.
     */
    public static RandomNumberService getInstance() {
        if (instance == null) {
            instance = new RandomNumberService();
        }
        return instance;
    }

    /**
     * Sets the random number generator strategy.
     * @param generator the strategy to use for random number generation.
     */
    public void setGenerator(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    /**
     * Generates a random number using the current strategy.
     * @return a random positive integer.
     * @throws IllegalStateException if no generator is set.
     */
    public int getRandomNumber() {
        if (generator == null) {
            throw new IllegalStateException("No random number generator strategy set");
        }
        return generator.generateRandomNumber();
    }
}
