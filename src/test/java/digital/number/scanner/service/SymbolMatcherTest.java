package digital.number.scanner.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;

import java.io.IOException;

public class SymbolMatcherTest {

    private SymbolMatcher objectUnderTest;

    @BeforeEach
    void initialize() throws IOException {
        objectUnderTest = new SymbolMatcher();
    }

    @Test
    public void canMatchSymbol(){
        String[] digitArrayBuffer = {" _  _  _  _  _  _  _  _  _ ", "| || || || || || || || || |", "|_||_||_||_||_||_||_||_||_|"};
        int initColumn = 0;
        Assertions.assertEquals("0", objectUnderTest.matchSymbol(digitArrayBuffer,initColumn));
    }
}
