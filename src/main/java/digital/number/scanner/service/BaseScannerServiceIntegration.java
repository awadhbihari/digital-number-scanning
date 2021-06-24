package digital.number.scanner.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/*
    Starting point of application.
    Scams a input file line by line and forward the request to be processed by LineProcesse
 */
public class BaseScannerServiceIntegration {

    public static final String ILLIGAL_CHARACTER_SUFIX = "ILL";
    private SymbolMatcher symbolMatcher;
    private DigitalNumberProcessor digitalNumberProcesser;
    private LineProcessor lineProcessor;
    public BaseScannerServiceIntegration(){

        symbolMatcher = new SymbolMatcher();
        digitalNumberProcesser = new DigitalNumberProcessor(symbolMatcher);
        lineProcessor = new LineProcessor(digitalNumberProcesser);
    }

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please provide a file path.");
            System.exit(1);
        }
        new BaseScannerServiceIntegration().performScanning(args[0]);
    }

    public List<String> performScanning(final String inputFilePath){
        Path inputPath = FileSystems.getDefault().getPath(inputFilePath);

        List<String> outputDigitalString = new ArrayList<>();
        try (Stream<String> stream = Files.lines(inputPath))
        {
            stream.forEach(line -> {
                lineProcessor.processLines(outputDigitalString, line);
            });

        } catch (IOException e) {
            System.out.println("Unable to read input file");
        }
        return outputDigitalString;
    }
}
