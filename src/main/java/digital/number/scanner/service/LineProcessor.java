package digital.number.scanner.service;

import java.util.List;

/*
       Process line to accommodate digital char sequence of 3 lines.
       One reading 3 lines the character array, the array is forward DigitalNumberProcesser, to get it converted to mapped digit
 */
public class LineProcessor {

    private int currentLineNo = 1;
    private String[] digitArrayBuffer = null;
    private DigitalNumberProcessor digitalNumberProcessor;

    public LineProcessor(DigitalNumberProcessor digitalNumberProcessor){

        this.digitalNumberProcessor = digitalNumberProcessor;
    }

    public void processLines(List<String> outputDigitalString, String line) {
    // Marks end of a digit with an empty line
        if(line.isBlank()) {
            currentLineNo = 1;
            // read mark next line as fresh line and consolidate line read so far if any.
            processEndOfDigit(outputDigitalString);
       // reading same digit
        } else {
            processDigitLine(outputDigitalString, line);
        }
    }

    // read max 3 line and mark next line as fresh line
    private void processDigitLine(List<String> outputDigitalString, String line) {
        if(currentLineNo ==1)
            digitArrayBuffer = new String[3];

        digitArrayBuffer[currentLineNo-1] = line;

        if(currentLineNo == 3) {
            currentLineNo = 1;
            outputDigitalString.add(this.digitalNumberProcessor.processDigitArray(digitArrayBuffer));
            digitArrayBuffer = null;
        } else
            currentLineNo++;
    }

    private void processEndOfDigit(List<String> outputDigitalString) {
        if(digitArrayBuffer != null)
            outputDigitalString.add(this.digitalNumberProcessor.processDigitArray(digitArrayBuffer));
    }
}
