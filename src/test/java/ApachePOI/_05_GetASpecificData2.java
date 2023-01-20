package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class _05_GetASpecificData2 {
    public static void main(String[] args) {

        String path = "src/test/java/ApachePOI/resource/timelog.xlsx";
        FileInputStream inputStream = null;
        Workbook workbook = null;
        Set<String> names = new LinkedHashSet<>();

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        String adSoyad = "";
        double toplamSaat = 0;

        HashMap<String,Double> list = new HashMap<>();

        for (int i = 1; i < rowCount; i++) {

            String flagName = "";

            Row row = sheet.getRow(i);
            Cell isimHucresi = row.getCell(2);
            Cell saatHucresi = row.getCell(6);

            adSoyad = isimHucresi.getStringCellValue();

            toplamSaat += saatHucresi.getNumericCellValue();

            list.put(adSoyad,toplamSaat);

            if (!flagName.equals(adSoyad)){
                toplamSaat=0;
            }

            names.add(adSoyad);
            flagName=adSoyad;

        }

        //System.out.println(names);
        System.out.println(list);


        // Proje isimleri set ile belirlenecek. (Duplicate)
        // Bir excel sheetinden alıp 2. sayfaya yazıcaz

    }

}
