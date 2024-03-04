package Utils;

public class Cell {
    private String cellValue;
    private String completeCellValue;

    public Cell() {
        this.cellValue = null;
    }

    public Cell(String cellValue) {
        this.cellValue = cellValue;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    public String getCompleteCellValue() {
        return completeCellValue;
    }

    public void setCompleteCellValue(String completeCellValue) {
        this.completeCellValue = completeCellValue;
    }
}
