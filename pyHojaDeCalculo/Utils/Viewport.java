package Utils;

public class Viewport {


    public static void showSheet(Sheet sheet, int cursorRow, int cursorCol, int spacing) { 

        int startRow = Math.max(0, cursorRow - Settings.VIEWPORT_HEIGHT / 2);
        int startCol = Math.max(0, cursorCol - Settings.VIEWPORT_WIDTH / 2);

        printHeaders(spacing, startRow, startCol);

        for (int i = startRow; i < Math.min(sheet.getRows(), cursorRow + Settings.VIEWPORT_HEIGHT); i++) {
            for (int j = startCol; j < Math.min(sheet.getColumns(), cursorCol + Settings.VIEWPORT_WIDTH); j++) {
                if (j == startCol) {
                    printIndex(spacing, i);
                }
                System.out.print(sheet.getCellContent(i, j));
            }
            System.out.println();
        }

        printBottom(spacing);
    }

    private static void printHeaders(int spacing, int startRow, int startCol) {
        System.out.print(" ".repeat(spacing));
        for (int i = startCol; i < startCol + Settings.VIEWPORT_WIDTH; i++) {
            System.out.print(" " + (char) (i + 65) + " ".repeat(spacing - 1));
        }
        System.out.println();
        System.out.print("+" + ("-".repeat(spacing - 1)));
        for (int i = 0; i < Settings.VIEWPORT_WIDTH + 1; i++) {
            System.out.print("+" + ("-".repeat(spacing)));
        }
        System.out.println();
    }

    private static void printIndex(int spacing, int index) {
        if (index < 10) {
            System.out.print(index + " ".repeat(spacing - 1) + "|");
        } else {
            System.out.print(index + " ".repeat(spacing - 2) + "|");
        }
    }

    private static void printBottom(int spacing) {
        System.out.print("+" + ("-".repeat(spacing - 1)));
        for (int i = 0; i < Settings.VIEWPORT_WIDTH + 1; i++) {
            System.out.print("+" + ("-".repeat(spacing)));
        }
        System.out.println();
    }
}
