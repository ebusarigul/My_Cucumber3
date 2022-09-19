package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        // hafızada yeni workbook olustur. sonra sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        Row newRow = sheet.createRow(0);  // 0. satır olusturuldu.
        Cell newCell = newRow.createCell(0);  // 0.satırda 0. hücre olusturuldu.
        newCell.setCellValue("Merhaba Apache");   // bilgi yazıldı

        for (int i = 1; i <10 ; i++) {

            newRow = sheet.createRow(i);
            for (int j = 0; j < 10 ; j++) {
                newRow.createCell(j).setCellValue("naber");
            }


        }

        //yazma işlemini YAZMA modunda açıp öyle yapacagız.
        String path = "src/test/java/ApachePOI/resource/NewExcelFile.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();






    }
}
