package org.howard.edu.lsp.finalexam.question2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RandomNumberServiceTest {

    @Test
    void testSingletonInstance() {
        RandomNumberService instance1 = RandomNumberService.getInstance();
        RandomNumberService instance2 = RandomNumberService.getInstance();
        assertSame(instance1, instance2, "RandomNumberService should be a singleton");
    }

    @Test
    void testJavaRandomNumberGenerator() {
        RandomNumberService service = RandomNumberService.getInstance();
        service.setGenerator(new JavaRandomNumberGenerator());

        int randomNumber = service.getRandomNumber();
        assertTrue(randomNumber > 0, "Random number should be positive");
    }

    @Test
    void testCustomRandomNumberGenerator() {
        RandomNumberService service = RandomNumberService.getInstance();
        service.setGenerator(new CustomRandomNumberGenerator());

        int randomNumber = service.getRandomNumber();
        assertTrue(randomNumber > 0, "Random number should be positive");
    }

    @Test
    void testUnsetGeneratorThrowsException() {
        RandomNumberService service = RandomNumberService.getInstance();
        service.setGenerator(null);

        Exception exception = assertThrows(IllegalStateException.class, service::getRandomNumber);
        assertEquals("No random number generator strategy set", exception.getMessage());
    }

    @Test
    void testSwitchingStrategies() {
        RandomNumberService service = RandomNumberService.getInstance();

        // First use Java's Random Number Generator
        service.setGenerator(new JavaRandomNumberGenerator());
        int javaRandom = service.getRandomNumber();
        assertTrue(javaRandom > 0, "Java random number should be positive");

        // Then switch to Custom Random Number Generator
        service.setGenerator(new CustomRandomNumberGenerator());
        int customRandom = service.getRandomNumber();
        assertTrue(customRandom > 0, "Custom random number should be positive");

        // Ensure numbers from the two generators are likely different
        assertNotEquals(javaRandom, customRandom, "Random numbers from different strategies should not be the same");
    }
}
