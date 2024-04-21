package Utils;

class Menu {

    private static final int viewportHeight = 10;
    private static final int viewportWith = 5;
    public static void showSheet(Sheet sheet, int cursorRow, int cursorCol) { 
        System.out.println("Hoja de Cálculo:");

        int startRow = Math.max(0, cursorRow - viewportHeight / 2);
        int startCol = Math.max(0, cursorCol - viewportWith / 2);

        for (int i = startRow; i < Math.min(sheet.getRows(), cursorRow + viewportHeight); i++) {
            for (int j = startCol; j < Math.min(sheet.getColumns(), cursorCol + viewportWith); j++) {
                    System.out.print(sheet.getCellContent(i, j));
            }
            System.out.println();
        }
    }

    public static void showMovementMenu(String currentCell) {
        System.out.println("Celda actual: " + currentCell);
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione R para cambiar el tamaño de las celdas.");
        System.out.println("Presione Q para salir.");
    }
}
