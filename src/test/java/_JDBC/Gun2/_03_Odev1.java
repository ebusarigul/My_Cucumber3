package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//Soru1 : getTable için yaptığını örneğin aynısını,
//bir XML filedan sorguyu parametre olarak göndererek bir
// Test için yapınız.

public class _03_Odev1 extends JDBCParent {


    @Parameters("sorgu")
    @Test
    public void getTable(String sorgu) throws SQLException {
        ResultSet rs = statement.executeQuery(sorgu);
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
