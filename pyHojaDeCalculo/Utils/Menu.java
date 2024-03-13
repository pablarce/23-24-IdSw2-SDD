package Utils;

class Menu {

    public static void showSheet(Sheet sheet) {
        System.out.println("Hoja de Cálculo:");
        for (int i = 0; i < sheet.getSheetData().length; i++) {
            for (int j = 0; j < sheet.getSheetData()[i].length; j++) {
                System.out.print(sheet.getCellContent(i, j));
            }
            System.out.println();
        }
    }

    public static void showMovementMenu(String currentCell) {
        System.out.println("Celda actual: " + currentCell);
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione E para editar la celda actual.");
        System.out.println("Presione S para cambiar el tamaño de las celdas.");
        System.out.println("Presione Q para salir.");
    }
}





