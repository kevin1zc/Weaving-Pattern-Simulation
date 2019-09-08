import java.util.HashMap;
import java.util.Map;

public class CrossingRule {

    private int[] rules = new int[9];

    private Map<CellValue, Integer> map;

    public CrossingRule(int ruleNum) {
        String ruleBits = Integer.toBinaryString(ruleNum);

        int offset = 9 - ruleBits.length();

        for (int i = 0; i < ruleBits.length(); i++) {
            rules[i + offset] = ruleBits.charAt(i) - '0';
        }

        map = new HashMap<>();
        map.put(CellValue.LeftTop, 0);
        map.put(CellValue.LeftUnpaired, 1);
        map.put(CellValue.RightUnpaired, 1);
        map.put(CellValue.RightTop, 2);

    }

    private CellValue generateCell(Cell left, Cell right) {
        if (left.getValue() == CellValue.Empty) {
            if (right.getValue() == CellValue.Empty || right.getValue() == CellValue.LeftUnpaired) {
                return CellValue.Empty;
            } else {
                return CellValue.RightUnpaired;
            }
        }

        if (right.getValue() == CellValue.Empty) {
            if (left.getValue() == CellValue.Empty || left.getValue() == CellValue.RightUnpaired) {
                return CellValue.Empty;
            } else {
                return CellValue.LeftUnpaired;
            }
        }

        if (left.getValue() == CellValue.RightUnpaired && right.getValue() == CellValue.LeftUnpaired) {
            return CellValue.Empty;
        }

        if (left.getValue() == CellValue.RightUnpaired) {
            return CellValue.RightUnpaired;
        }

        if (right.getValue() == CellValue.LeftUnpaired) {
            return CellValue.LeftUnpaired;
        }

        int result = rules[map.get(left.getValue()) * 3 + 2 - map.get(right.getValue())];
        return result == 1 ? CellValue.LeftTop : CellValue.RightTop;
    }

    public Cell[] generateNextRow(Cell[] curRow, int curRowIndex) {
        int width = curRow.length;
        Cell[] newRow = new Cell[width];
        for (int l = 0; l < width; l++) {
            int r = (l + 1) % width;
            if (curRowIndex % 2 == 0) {
                newRow[l] = new Cell(generateCell(curRow[l], curRow[r]));
            } else {
                newRow[r] = new Cell(generateCell(curRow[l], curRow[r]));
            }
        }
        return newRow;
    }

}
