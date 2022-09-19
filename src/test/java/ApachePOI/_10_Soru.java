package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _10_Soru {
    public static void main(String[] args) {


        // hafızada yeni workbook olustur. sonra sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("CarpimTablo");

        for (int i = 1; i <10 ; i++) {
            Row newRow = sheet.createRow(i);
            for (int j = 1; j <10 ; j++) {

            }
        }
    
    
    
    
    
    
    
    
    
    
    }
}
