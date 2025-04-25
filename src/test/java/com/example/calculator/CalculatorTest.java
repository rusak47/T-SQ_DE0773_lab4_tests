package com.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @Tag("Arithmetic")
    @DisplayName("Add various values")
    @CsvSource({
            "1, 2, 3",
            "-1, 1, 0",
            "0.1, 0.2, 0.3"
    })
    void add_variousInputs_expectedResult(double a, double b, double expected) {
        assertEquals(expected, Calculator.add(a, b), 0.001);
    }

    @ParameterizedTest
    @Tag("Arithmetic")
    @DisplayName("Subtract various values")
    @CsvSource({
            "5, 2, 3",
            "0, 3, -3",
            "3.5, 1.2, 2.3"
    })
    void subtract_variousInputs_expectedResult(double a, double b, double expected) {
        assertEquals(expected, Calculator.subtract(a, b), 0.001);
    }

    @ParameterizedTest
    @Tag("Arithmetic")
    @DisplayName("Multiply various values")
    @CsvSource({
            "2, 3, 6",
            "-1, 5, -5",
            "0.5, 2, 1"
    })
    void multiply_variousInputs_expectedResult(double a, double b, double expected) {
        assertEquals(expected, Calculator.multiply(a, b), 0.001);
    }

    @Test
    @Tag("Boundary")
    void divide_byZero_throwsException() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }

    @Test
    @Tag("Arithmetic")
    void divide_validInputs_expectedResult() {
        assertEquals(2.5, Calculator.divide(5, 2), 0.001);
    }

    @ParameterizedTest
    @Tag("Fibonacci")
    @CsvSource({"0,0", "1,1", "2,1", "5,5", "10,55"})
    void fibonacci_recursive_expectedResult(int input, int expected) {
        assertThat(Calculator.fibonacci(input), is(expected));
    }

    @ParameterizedTest
    @Tag("Fibonacci")
    @CsvSource({"0,0", "1,1", "2,1", "5,5", "10,55"})
    void fibonacci_iterative_expectedResult(int input, int expected) {
        assertThat(Calculator.fibonacciIterative(input), is(expected));
    }

    @Test
    void fibonacci_negative_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.fibonacci(-1));
    }

    @ParameterizedTest
    @Tag("Lucas")
    @CsvSource({"0,2", "1,1", "2,3", "3,4", "5,11", "10,123"})
    void lucas_knownValues_expectedResult(int input, int expected) {
        assertThat(Calculator.lucas(input), is(expected));
    }

    @Test
    void lucas_negative_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.lucas(-1));
    }
}