package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */

public class _07_Soru {
    public static void main(String[] args) {
        System.out.println("süton no giriniz = ");
        Scanner oku = new Scanner(System.in);
        String sutun = oku.next();

        findSutun(sutun);

    }
    private static void findSutun(String sutun) {

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream inputStream = null;
        Workbook workbook = null;
        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet("Login");

        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i <rowCount ; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(Integer.parseInt(sutun));

            if (cell != null){
                System.out.println(cell + " ");
            }
        }
        System.out.println();




    }

}
