public class Cell {

    private CellValue value;

    public Cell(char input) {
        switch (input) {
            case '1':
                value = CellValue.LeftTop;
                break;
            case '0':
                value = CellValue.RightTop;
                break;
            case '/':
                value = CellValue.LeftUnpaired;
                break;
            case '\\':
                value = CellValue.RightUnpaired;
                break;
            case ' ':
                value = CellValue.Empty;
                break;
        }
    }

    public Cell(CellValue cellValue) {
        value = cellValue;
    }

    public CellValue getValue() {
        return this.value;
    }

    public char getCharValue() {
        switch (value) {
            case LeftTop:
                return '1';
            case RightTop:
                return '0';
            case LeftUnpaired:
                return '/';
            case RightUnpaired:
                return '\\';
            case Empty:
                return ' ';
            default:
                return '\0';
        }
    }

}
