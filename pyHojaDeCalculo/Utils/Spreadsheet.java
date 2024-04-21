package Utils;

import java.util.Scanner;

public class Spreadsheet {
    private Sheet sheet;
    private Movement movement;
    private Scanner input;
    private int rows = 10;
    private int columns = 10;

    public Spreadsheet() {
        sheet = new Sheet(rows, columns);
        movement = new Movement();
        input = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            Menu.showSheet(sheet, movement.getFormattedRow(sheet.getCurrentCell()),
                    movement.getFormattedColumn(sheet.getCurrentCell()));
            Menu.showMovementMenu(sheet.getCurrentCell());
            String command = input.nextLine().toLowerCase();
            if (command.equals("q")) {
                running = false;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + sheet.getCurrentCell() + ":");
                int row = movement.getFormattedRow(sheet.getCurrentCell());
                int column = movement.getFormattedColumn(sheet.getCurrentCell());
                String result = MathOperations.evaluateFormula(input.nextLine(), sheet);
                sheet.setCellValue(row, column, result);
            } else if (command.equals("r")) {
                System.out.println("Ingrese el tamaño que desea: ");
                int newSize = Integer.parseInt(input.nextLine());
                sheet.setCellSize(newSize);
                System.out.println("Tamaño actualizado a: " + sheet.getSpacing());
            }

            else {
                sheet.setCurrentCell(movement.handleCommand(command, sheet.getCurrentCell()));
            }
        }
        input.close();
    }
}
