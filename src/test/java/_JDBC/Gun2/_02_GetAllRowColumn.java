package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _02_GetAllRowColumn extends JDBCParent {


    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        System.out.println("ColumnCount = " + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            String columnType = rsmd.getColumnTypeName(i);

            System.out.println("columnType  = " + columnType);
            System.out.println("columnName = " + columnName);
            System.out.println("------------------------------");

        }
    }

    @Test
    public void test2() throws SQLException{

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++){
            String columnName = rsmd.getColumnName(i);
            System.out.print(columnName + "   ");
        }

        System.out.println();

        while (rs.next()){

            for (int i = 1; i <=columnCount ; i++) {
                System.out.print(rs.getString(i)+"   ");
            }
            System.out.println();
        }
    }

    @Test
    public void test3() throws SQLException{

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++){
            String columnName = rsmd.getColumnName(i);
            System.out.printf("%-14s",columnName);
            // % : değişkenin değerini işaret eder
            // - : sola dayalı yazdırır, default sağa dayalı
            // 20: kaç hane kullanılacak herzaman onun bilgisi
            // s : string değerler içis , sayısal değerler için d kullanılır
            // "%5.2d" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane
        }

        System.out.println();

        while (rs.next()){
            for (int i = 1; i <=columnCount ; i++) {
                System.out.printf("%-14s",rs.getString(i));
            }
            System.out.println();
        }
    }

    @Test
    public void test4() throws SQLException{
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.
        getTable("select * from actor");

    }

    public void getTable(String query) throws SQLException {
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++){
            String columnName = rsmd.getColumnName(i);
            System.out.printf("%-14s",columnName);
        }

        System.out.println();

        while (rs.next()){

            for (int i = 1; i <=columnCount ; i++) {
                System.out.printf("%-14s",rs.getString(i));
            }
            System.out.println();
        }
    }


}
