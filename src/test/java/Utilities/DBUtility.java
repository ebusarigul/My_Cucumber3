package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static Connection connection;
    protected static Statement statement;

    public static void DBConnectionOpen() {

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void DBConnectionClose() {

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<List<String>> getListData(String sorgu) {
        List<List<String>> tablo = new ArrayList<>();
        // db den bütün satır ve sütunları okuyup bu listeye atıcam.

        //db baglantıyı ac
        DBConnectionOpen();
        try {
            //1-sorguyu calıstır
            ResultSet rs = statement.executeQuery(sorgu);//
            // 2- bütün satır sutunları okuyup tabloya ekle
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()){

                List<String> satir = new ArrayList<>();
                for (int i = 1; i <=columnCount ; i++) {
                   satir.add(rs.getString(i));
                }
                tablo.add(satir);
            }

        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
        //db baglantısını kapat
        DBConnectionClose();
        return tablo;
    }

}
