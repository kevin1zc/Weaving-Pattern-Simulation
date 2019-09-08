import javax.swing.text.View;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the starting row.");
        String startingRow = scanner.nextLine();
        int width = startingRow.length();

        Cell[] curRow = new Cell[width];

        for (int i = 0; i < curRow.length; i++) {
            curRow[i] = new Cell(startingRow.charAt(i));
        }

        System.out.println("Please enter the crossing rule.");
        int ruleNum = scanner.nextInt();
        CrossingRule crossingRule = new CrossingRule(ruleNum);

        Printer printer = new Printer(width);

        List<String> printed = new ArrayList<>();

        int curRowIndex = 0;
        int repeatLength = -1;

        boolean repeated = false;

        while (!repeated) {
            String newRowStr = printer.addPattern(curRow, curRowIndex);

            int[] checkRepeat = checkRepeat(printed, newRowStr, width);

            if (checkRepeat[0] == 1) {
                repeated = true;
                repeatLength = checkRepeat[1];
            }

            printed.add(newRowStr);
            curRow = crossingRule.generateNextRow(curRow, curRowIndex);

            curRowIndex++;

        }

        printer.print();

        System.out.println("Pattern width = " + curRow.length);
        System.out.println("Repeat length = " + repeatLength);
        System.out.println("Total length = " + printer.getCnt());
    }

    private static int[] checkRepeat(List<String> list, String newString, int width) {
        int[] result = {0, 0};
        for (int i = 0; i < list.size(); i++) {
            String existing = list.get(i);
            for (int offset = 0; offset < width; offset++) {
                boolean repeated = true;
                for (int start = 0; start < width; start++) {
                    if (existing.charAt(start) != newString.charAt((offset + start) % width)) {
                        repeated = false;
                        break;
                    }
                }
                if (repeated) {
                    result[0] = 1;
                    result[1] = list.size() - i;
                    return result;
                }
            }
        }
        return result;
    }

}