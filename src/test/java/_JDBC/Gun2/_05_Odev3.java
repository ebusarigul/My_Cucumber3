package _JDBC.Gun2;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _05_Odev3 {

    private static Connection connection;
    protected static Statement statement;

    @Test
    public void test3() throws SQLException, IOException {

        //DB connection
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/z_ebu1";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();

        //create a newtable in database
        String sql = "create table kisiTablo (no int, ad varchar(40),soyad varchar(40),telefon int)";
        statement.execute(sql);

        //Excel
        String path = "src/test/java/ApachePOI/resource/kisiTablo.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");

        int rows = sheet.getLastRowNum();

        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            double no = row.getCell(0).getNumericCellValue();
            String ad = row.getCell(1).getStringCellValue();
            String soyad = row.getCell(2).getStringCellValue();
            double telefon = row.getCell(3).getNumericCellValue();

            sql = "insert into kisiTablo values('"+no+"','"+ad+"','"+soyad+"','"+telefon+"')";
            statement.execute(sql);
            statement.execute("commit");
        }

        workbook.close();
        inputStream.close();
        connection.close();

    }

}
