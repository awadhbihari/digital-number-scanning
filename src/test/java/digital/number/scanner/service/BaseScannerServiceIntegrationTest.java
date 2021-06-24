package digital.number.scanner.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for basic end-to-end functional validations.
 * Please feel free to add more test classes for the purpose of unit/integration testing of your own implementation.
 * <p>
 * Add your test cases and their expect outputs under src/test/resources testInput and testOutput directories respectively.
 * The input and output will be paired with each other if they have matching file name.
 * <p>
 * @apiNote Implement {@link #performScanning} to return list of output given an input file path.
 * Please note that this does not necessarily define the API contract of your scanner service implementation.
 */
@RunWith(Parameterized.class)
public class BaseScannerServiceIntegrationTest {

    private static final String INPUT_DIR = "testInput";
    private static final String OUTPUT_DIR = "testOutput";
    private BaseScannerServiceIntegration objectUnderTest;

    @Parameterized.Parameter
    public String inputFileName;

    @BeforeEach
    void initialize() throws IOException {
        objectUnderTest = new BaseScannerServiceIntegration();
    }

    @Parameterized.Parameters(name = "{0}")
    public static List<String> inputFileNames() throws IOException {
        Path inputDirPath = Paths.get("src", "test", "resources", INPUT_DIR);
        return Files.list(inputDirPath)
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toList());
    }

    @Test
    public final void testScanner() throws IOException {
        String inputFilePath = Paths.get("src", "test", "resources", INPUT_DIR, "example").toAbsolutePath().toString();
        List<String> expectedOutput = Files.readAllLines(Paths.get("src", "test", "resources", OUTPUT_DIR, "example"));
        objectUnderTest = new BaseScannerServiceIntegration();
        assertThat(objectUnderTest.performScanning(inputFilePath)).containsExactlyElementsOf(expectedOutput);
    }

    @Test
    public final void testMultipleDigitScanner() throws IOException {
        String inputFilePath = Paths.get("src", "test", "resources", INPUT_DIR, "multipleDigits").toAbsolutePath().toString();
        List<String> expectedOutput = Files.readAllLines(Paths.get("src", "test", "resources", OUTPUT_DIR, "multipleDigits"));
        objectUnderTest = new BaseScannerServiceIntegration();
        assertThat(objectUnderTest.performScanning(inputFilePath)).containsExactlyElementsOf(expectedOutput);
    }

    @Test
    public final void testIlligalCharacterScanner() throws IOException {
        String inputFilePath = Paths.get("src", "test", "resources", INPUT_DIR, "illigalCharacter").toAbsolutePath().toString();
        List<String> expectedOutput = Files.readAllLines(Paths.get("src", "test", "resources", OUTPUT_DIR, "illigalCharacter"));
        objectUnderTest = new BaseScannerServiceIntegration();
        assertThat(objectUnderTest.performScanning(inputFilePath)).containsExactlyElementsOf(expectedOutput);
    }
}
