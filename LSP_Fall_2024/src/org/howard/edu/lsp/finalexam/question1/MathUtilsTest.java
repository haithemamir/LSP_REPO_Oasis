package org.howard.edu.lsp.finalexam.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    private final MathUtils mathUtils = new MathUtils();

    // Test cases for factorial method
    @Test
    void factorial_shouldReturn1ForInput0() {
        assertEquals(1, mathUtils.factorial(0), "Factorial of 0 should be 1");
    }

    @Test
    void factorial_shouldReturnFactorialForPositiveInput() {
        assertEquals(120, mathUtils.factorial(5), "Factorial of 5 should be 120");
        assertEquals(5040, mathUtils.factorial(7), "Factorial of 7 should be 5040");
    }

    @Test
    void factorial_shouldThrowExceptionForNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mathUtils.factorial(-1));
        assertEquals("Number must be non-negative", exception.getMessage());
    }

    // Test cases for isPrime method
    @Test
    void isPrime_shouldReturnFalseForNumbersLessThanOrEqualTo1() {
        assertFalse(mathUtils.isPrime(0), "0 is not a prime number");
        assertFalse(mathUtils.isPrime(1), "1 is not a prime number");
    }

    @Test
    void isPrime_shouldReturnTrueForPrimeNumbers() {
        assertTrue(mathUtils.isPrime(2), "2 is a prime number");
        assertTrue(mathUtils.isPrime(13), "13 is a prime number");
        assertTrue(mathUtils.isPrime(29), "29 is a prime number");
    }

    @Test
    void isPrime_shouldReturnFalseForNonPrimeNumbers() {
        assertFalse(mathUtils.isPrime(4), "4 is not a prime number");
        assertFalse(mathUtils.isPrime(15), "15 is not a prime number");
        assertFalse(mathUtils.isPrime(100), "100 is not a prime number");
    }

    // Test cases for gcd method
    @Test
    void gcd_shouldReturnAbsoluteValueWhenOneNumberIsZero() {
        assertEquals(5, mathUtils.gcd(0, 5), "GCD of 0 and 5 should be 5");
        assertEquals(7, mathUtils.gcd(7, 0), "GCD of 7 and 0 should be 7");
    }

    @Test
    void gcd_shouldReturnGreatestCommonDivisorForTwoPositiveNumbers() {
        assertEquals(6, mathUtils.gcd(54, 24), "GCD of 54 and 24 should be 6");
        assertEquals(1, mathUtils.gcd(17, 13), "GCD of 17 and 13 should be 1");
        assertEquals(10, mathUtils.gcd(100, 10), "GCD of 100 and 10 should be 10");
    }

    @Test
    void gcd_shouldThrowExceptionWhenBothNumbersAreZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mathUtils.gcd(0, 0));
        assertEquals("Both numbers cannot be zero", exception.getMessage());
    }
}
