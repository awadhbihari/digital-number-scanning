package digital.number.scanner.service;

import java.util.List;
/*
Process the character sequence to get a valid digital sequence, one digit at a time.
Also produce the
 */
import static digital.number.scanner.service.BaseScannerServiceIntegration.ILLIGAL_CHARACTER_SUFIX;

public class DigitalNumberProcessor {

    private SymbolMatcher symbolMatcher;

    public String processDigitArray(String[] digitArrayBuffer) {

        StringBuffer sb = new StringBuffer();
        boolean illigalCharFound = false;
        for(int j=0; j<27;j=j+3){
            String value = symbolMatcher.matchSymbol(digitArrayBuffer, j);
            sb.append(value);
            if(DigitalSymbol.unmatched.getValue().equals(value))
                illigalCharFound = true;
        }
        if(illigalCharFound)
            sb.append(ILLIGAL_CHARACTER_SUFIX);

        System.out.println(sb.toString());
        return sb.toString();
    }

    public DigitalNumberProcessor(SymbolMatcher symbolMatcher) {
        this.symbolMatcher = symbolMatcher;
    }
}
