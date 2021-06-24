package digital.number.scanner.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.List;

public class LineProcessorTest {
    private LineProcessor objectUnderTest;

    @BeforeEach
    void initialize() throws IOException {
        objectUnderTest = new LineProcessor(new DigitalNumberProcessor(new SymbolMatcher()));
    }

    @Test
    public void processFirstLines(){

    }

    @Test
    public void processLastLines(){

    }

    @Test
    public void processLineBreak(){

    }

}
