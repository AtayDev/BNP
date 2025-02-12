package com.example.simon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    private final LoggerService loggerService;
    private final ValidationService validationService;

    @Autowired
    public CalculationService(LoggerService loggerService, ValidationService validationService) {
        this.loggerService = loggerService;
        this.validationService = validationService;
    }

    public long calcTVPI(long paidIn, long totalValue) {
        if (!validationService.isValidInput(paidIn, totalValue)) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        loggerService.log("Calculating TVPI with paidIn: " + paidIn + ", totalValue: " + totalValue);
        return (long) paidIn / totalValue;
    }

    public long calcMultiplication(long a, long b) {
        loggerService.log("Multiplying " + a + " * " + b);
        return a * b;
    }

    public double calcDivision(long a, long b) {
        if (b == 0) {
            loggerService.log("Attempt to divide by zero.");
            throw new ArithmeticException("Cannot divide by zero");
        }
        loggerService.log("Dividing " + a + " / " + b);
        return (double) a / b;
    }

    public long calcAddition(long a, long b) {
        loggerService.log("Adding " + a + " + " + b);
        return a + b;
    }

    public long calcSubtraction(long a, long b) {
        loggerService.log("Subtracting " + a + " - " + b);
        return a - b;
    }
}
