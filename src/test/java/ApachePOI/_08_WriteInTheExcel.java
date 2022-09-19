package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

        // Var olan bir EXCEL e yazma işlemi

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // okuma modunda açıldı
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        Row newRow = sheet.createRow(0);  // 0. satır olusturuldu.
        Cell newCell = newRow.createCell(0);  // 0.satırda 0. hücre olusturuldu.
        newCell.setCellValue("Merhaba Apache");   // bilgi yazıldı

        for (int i = 1; i <10 ; i++) {

            newRow = sheet.createRow(i);
            for (int j = 0; j < 10 ; j++) {
                newRow.createCell(j).setCellValue("naber");
            }


        }

        // sıra kaydetmeye geldi. bütün bilgiler hafızada
        inputStream.close(); // okuma modunu kapattım, çünkü yazma modunda açmam gerekiyor

        //yazma işlemini YAZMA modunda açıp öyle yapacagız.

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();






    }
}
