package digital.number.scanner.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DigitalNumberProcessorTest {
    private DigitalNumberProcessor objectUnderTest;

    @BeforeEach
    void initialize() throws IOException {
        objectUnderTest = new DigitalNumberProcessor(new SymbolMatcher());
    }

    @Test
    public void canProcessDigitArray(){
        String[] digitArrayBuffer = {" _  _  _  _  _  _  _  _  _ ", "| || || || || || || || || |", "|_||_||_||_||_||_||_||_||_|"};
        String expectedValue = "000000000";
        Assertions.assertEquals(expectedValue, objectUnderTest.processDigitArray(digitArrayBuffer));
    }
}
