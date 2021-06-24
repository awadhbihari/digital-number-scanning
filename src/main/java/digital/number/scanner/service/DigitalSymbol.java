package digital.number.scanner.service;

enum DigitalSymbol {

    zero("0", new char[][]{{' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'}}),
    one("1", new char[][]{{' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}}),
    two("2", new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {'|', '_', ' '}}),
    three("3", new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'}}),
    four("4", new char[][]{{' ', ' ', ' '}, {'|', '_', '|'}, {' ', ' ', '|'}}),
    five("5", new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {' ', '_', '|'}}),
    six("6", new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {'|', '_', '|'}}),
    seven("7", new char[][]{{' ', '_', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}}),
    eight("8", new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {'|', '_', '|'}}),
    nine("9", new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {' ', '_', '|'}}),
    unmatched("?", new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}});

    public String getValue() {
        return value;
    }

    public char[][] getChars() {
        return chars;
    }

    private String value;
    private char[][] chars;

    DigitalSymbol(String value, char[][] chars) {

        this.value = value;
        this.chars = chars;
    }
}
