package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {

        // dosyanın yolu alındı
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        // dosya okuma islemcisine dosyanın yolunu veriyoruz.
        // böylece program ile dosaya arasında baglantı olustu
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);

        // dosya okuma islemcisi üzerinden Çalısma Kitabını alıyorum.
        // hafızada workbook u alıp olusturdu
        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);

        Sheet calismaSayfasi = calismaKitabi .getSheet("Sheet1");

        //istenen satırı alıyorum.
        Row satir = calismaSayfasi .getRow(0);

        //istenen satırdaki istenen hücre alınıyor.
        Cell hucre = satir. getCell(0);

        System.out.println(hucre);

    }
}
