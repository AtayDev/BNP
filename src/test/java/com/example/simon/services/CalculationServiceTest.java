package com.example.simon.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class) // Enables Mockito for JUnit 5
class CalculationServiceTest {

    @Mock
    LoggerService loggerService;
    @Mock
    ValidationService validationService;

    @InjectMocks
    CalculationService calculationService;

    @Test
    void calcTVPI_ValidInputs() {
        long paidIn = 10;
        long totalValue = 5;
        when(validationService.isValidInput(paidIn,totalValue)).thenReturn(true);
        assertEquals(2.0, calculationService.calcTVPI(10,5));
        verify(loggerService).log("Calculating TVPI with paidIn: " + paidIn + ", totalValue: " + totalValue);
    }

    @Test
    void calcTVPI_InvalidInputs(){
        long paidIn = 10;
        long totalValue = -1;

        when(validationService.isValidInput(paidIn, totalValue)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, ()->{
            calculationService.calcTVPI(10,-1);
        });
    }

}