package digital.number.scanner.service;
/*
Matches the character sequence to a valid digital sequence .
If un match return unmatched character
 */
public class SymbolMatcher {

    public String matchSymbol(String[] digitArrayBuffer, int initColumn){

            for (DigitalSymbol value : DigitalSymbol.values()) {
                boolean symbolBreak = false;
            for(int i=0; i<3 && !symbolBreak;i++) {
                for (int j = initColumn; j < initColumn+3; j++) {
                    if(digitArrayBuffer[i].length() <= j || value.getChars()[i][j-initColumn] != digitArrayBuffer[i].charAt(j)) {
                        symbolBreak =  true;
                        break;
                    }
                }
            }
            if(!symbolBreak)
                return value.getValue();
            }
            return DigitalSymbol.unmatched.getValue();
    }
}
