package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Soru {
    public static void main(String[] args) throws IOException {


        // hafızada yeni workbook olustur. sonra sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("CarpimTablo");

        int rowCount = 0;
        for (int i = 1; i <10 ; i++) {

            for (int j = 1; j <10 ; j++) {

                Row newRow = sheet.createRow(rowCount);
                rowCount++;

                newRow.createCell(0).setCellValue(i);
                newRow.createCell(1).setCellValue("x");
                newRow.createCell(2).setCellValue(j);
                newRow.createCell(3).setCellValue("=");
                newRow.createCell(4).setCellValue(i*j);

            }
            rowCount++;
        }
        String path = "src/test/java/ApachePOI/resource/CarpimTablo.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    
    }
}
