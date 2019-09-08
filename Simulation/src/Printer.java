import java.util.Stack;

public class Printer {

    private int width;
    private Stack<String> stack;
    private int cnt;

    public Printer(int gridWidth) {
        width = gridWidth;
        stack = new Stack<>();
        cnt = 0;
    }

    private void addSplitter() {
        StringBuilder builder = new StringBuilder();
        builder.append(ANSIColor.BLUE_BOLD);
        for (int i = 0; i < width; i++) {
            builder.append("------");
        }
        builder.append("-");
        builder.append(ANSIColor.RESET);

        stack.push(builder.toString());
    }

    public String addPattern(Cell[] cells, int row) {
        addSplitter();

        cnt++;

        StringBuilder builder = new StringBuilder();
        StringBuilder toReturn = new StringBuilder();

        if (row % 2 == 0) {
            builder.append(ANSIColor.BLUE_BOLD);
            builder.append("|");
            builder.append(ANSIColor.RESET);

            for (Cell cell : cells) {
                builder.append("  ");

                builder.append(ANSIColor.RED_BOLD);
                builder.append(cell.getCharValue());
                builder.append(ANSIColor.RESET);

                toReturn.append(cell.getCharValue());

                builder.append(ANSIColor.BLUE_BOLD);
                builder.append("  |");
                builder.append(ANSIColor.RESET);
            }
        } else {
            builder.append(ANSIColor.RED_BOLD);
            builder.append(cells[cells.length - 1].getCharValue());
            builder.append(ANSIColor.RESET);
            for (Cell cell : cells) {
                builder.append(ANSIColor.BLUE_BOLD);
                builder.append("  |  ");
                builder.append(ANSIColor.RESET);

                builder.append(ANSIColor.RED_BOLD);
                builder.append(cell.getCharValue());
                builder.append(ANSIColor.RESET);

                toReturn.append(cell.getCharValue());
            }
        }
        builder.append("        ");
        String returnString = toReturn.toString();
        builder.append(returnString);
        stack.push(builder.toString());
        return returnString;
    }

    public void print() {
        addSplitter();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public int getCnt() {
        return cnt;
    }

}
