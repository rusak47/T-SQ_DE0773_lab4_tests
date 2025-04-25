package com.example.calculator;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);
    private static final Map<Integer, Integer> fibMemo = new HashMap<>();
    private static final Map<Integer, Integer> lucasMemo = new HashMap<>();

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            log.error("Division by zero attempted: divide({}, {})", a, b);
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public int fibonacci(int n) {
        if (n < 0) {
            log.error("Invalid Fibonacci input: {}", n);
            throw new IllegalArgumentException("Fibonacci input must be >= 0");
        }
        if (n <= 1) return n;
        if (fibMemo.containsKey(n)) return fibMemo.get(n);
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        fibMemo.put(n, result);
        return result;
    }

    public int fibonacciIterative(int n) {
        if (n < 0) {
            log.error("Invalid Fibonacci input (iterative): {}", n);
            throw new IllegalArgumentException("Fibonacci input must be >= 0");
        }
        if (n == 0) return 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public int lucas(int n) {
        if (n < 0) {
            log.error("Invalid Lucas input: {}", n);
            throw new IllegalArgumentException("Lucas input must be >= 0");
        }
        if (n == 0) return 2;
        if (n == 1) return 1;
        if (lucasMemo.containsKey(n)) return lucasMemo.get(n);
        int result = lucas(n - 1) + lucas(n - 2);
        lucasMemo.put(n, result);
        return result;
    }
}