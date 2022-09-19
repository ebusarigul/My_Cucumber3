package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.IOException;

/**
 Bir önceki yapılan soruda, Kullanıcıya 1.sütundaki tüm değer bir liste halinde kullanıcıya
 yanlarında bi numara olarak sunalım. Kullanıcı hangi numararyı girerese o satırın
 yanındaki tüm bilgiler gösterilsin.
 Username için 1
 Password için 2
 ....
 ...
 giririniz = 2
 */

/**
 * Verilen Exceldeki password bilgisini bir metod aracılığı ile bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değr password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */


public class _05_GetASpecificData {
    public static void main(String[] args){

        findInfo("password");
        findInfo("address");
        findInfo("username");
        findInfo("zipcode");

    }

    private static void findInfo(String p){
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

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            if (p.equalsIgnoreCase(String.valueOf(cell))) {
                int cellCount = row.getPhysicalNumberOfCells();
                for (int j = 1; j < cellCount; j++) {
                    cell = row.getCell(j);

                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    }

}
