package Utils;

import java.util.Scanner;

public class HojaDeCalculo {
    private Sheet sheet;
    private Movement movement;
    private Scanner input;

    public HojaDeCalculo() {
        sheet = new Sheet(18, 11);
        movement = new Movement();
        input = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            Menu.showSheet(sheet);
            Menu.showMovementMenu(sheet.getCurrentCell(),
                sheet.getSheetData()[movement.getCurrentRow(sheet.getCurrentCell())+2]
                                    [movement.getCurrentColumn(sheet.getCurrentCell()) + 1]
                                        .getCompleteCellValue());
            String command = input.nextLine();
            if (command.equals("q")) {
                break;
            } else if (command.equals("e")) {
                System.out.println("Ingrese el nuevo valor de la celda " + sheet.getCurrentCell() + ":");
                String newValue = input.nextLine();
                sheet.setCellValue(movement.getCurrentRow(sheet.getCurrentCell()),
                        movement.getCurrentColumn(sheet.getCurrentCell()), newValue);
                System.out.println("Valor de la celda " + sheet.getCellContent(movement.getCurrentRow(sheet.getCurrentCell())+2, movement.getCurrentColumn(sheet.getCurrentCell())+1) + " cambiado a " + newValue);
            } else {
                sheet.setCurrentCell(movement.handleCommand(command, sheet.getCurrentCell()));
            }
        }
        input.close();
    }
}