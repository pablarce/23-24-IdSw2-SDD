package Utils.Model;

import Utils.Model.Cell;

public class Sheet {
    private Cell[][] sheetData;
    private String currentCell;
    private int spacing = 8;

    public Sheet(int rows, int columns) {
        sheetData = new Cell[rows][columns];
        currentCell = "A0";
        fillSheetData(rows, columns);
    }

    public void fillSheetData(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sheetData[i][j] = new Cell(i, j);
            }
        }
    }

    public String getCellContent(int i, int j) {

        if (getCellLetter(i, j).equals(this.currentCell)) {
            if (this.sheetData[i][j].getCellValue() == null) {
                return "[" + (" ").repeat(spacing - 2) + "]" + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();

                if (cellValue.length() > spacing - 2) {
                    cellValue = cellValue.substring(0, spacing - 2);
                }
                return "[" + cellValue + " ".repeat(spacing - 2 - cellValue.length()) + "]" + "|";
            }
        } else {
            if (this.sheetData[i][j].getCellValue() == null) {
                return (" ").repeat(spacing) + "|";
            } else {
                String cellValue = this.sheetData[i][j].getCellValue();

                if (cellValue.length() > spacing) {
                    cellValue = cellValue.substring(0, spacing);
                }
                return cellValue + " ".repeat(spacing - cellValue.length()) + "|";
            }
        }
    }

    public int getSpacing() {
        return spacing;
    }

    static String getCellLetter(int i, int j) {
        return (char) (j + 65) + String.valueOf(i);
    }

    public String getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(String currentCell) {
        this.currentCell = currentCell;
    }

    public void setCellValue(int row, int col, String value) {
        sheetData[row][col].setCellValue(value);
    }

    public Cell[][] getSheetData() {
        return sheetData;
    }

    public int getRows() {
        return sheetData.length;
    }

    public int getColumns() {
        return sheetData[0].length;
    }

    public void setCellSize(int size) {
        this.spacing = size;
        if (this.spacing < 1) {
            this.spacing = 1;
        }
    }
}