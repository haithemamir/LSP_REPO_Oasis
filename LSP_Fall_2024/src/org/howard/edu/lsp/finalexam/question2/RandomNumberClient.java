package org.howard.edu.lsp.finalexam.question2;

/**
 * Client program to demonstrate the RandomNumberService.
 */
public class RandomNumberClient {
    public static void main(String[] args) {
        RandomNumberService service = RandomNumberService.getInstance();

        // Use Java's random number generator
        service.setGenerator(new JavaRandomNumberGenerator());
        System.out.println("Random number using Java's Random: " + service.getRandomNumber());

        // Use custom random number generator
        service.setGenerator(new CustomRandomNumberGenerator());
        System.out.println("Random number using Custom Generator: " + service.getRandomNumber());
    }
}
