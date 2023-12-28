import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) {
        try {
            // Load the Excel file
            FileInputStream excelFile = new FileInputStream("example.xlsx");
            Workbook workbook = new XSRFWorkbook(excelFile);

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows and columns
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Print cell value to console
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println(); // Move to the next row
            }

            // Close the workbook
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
