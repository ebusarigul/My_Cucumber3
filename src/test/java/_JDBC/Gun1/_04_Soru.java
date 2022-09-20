package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    //city tablosundaki tüm kayıtları next ile yazdırınız
    //city tablosundaki tüm kayıtları absolute ile yazdırınız
    //city tablosundaki tüm kayıtları relative ile yazdırınız


    @Test
    private void soru1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from city");

        while (rs.next()){
            System.out.println("city Name = " + rs.getString(2));
        }
    }
    @Test
    private void soru2() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from city");

        int count=1;
        while (rs.absolute(count)){
            System.out.println("city Name = " + rs.getString(2));
            count++;
        }
    }
    @Test
    private void soru3() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from city");

        int count=1;
        while (rs.relative(count)){
            System.out.println("city Name = " + rs.getString(2));
        }
    }


}
