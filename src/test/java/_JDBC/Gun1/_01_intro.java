package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_intro {
//1- connection : önce bağlantı ayarlarını yaptık. username, password, url(port,db,bağlantı yolu)

//2- Sorgu çalıştırma yolu : sorgularımı çalıştırmak için bir sayfa(yol) açtım.

//3- Sonuçların alınması : sorgunun çalışması sonucu veritabanından gelen bilgiler.


    @Test
    public void test1() throws SQLException {

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila"; // hostname,port/db adını
        String username = "root"; // username
        String password = "'\"-LhCB'.%k[4S]z"; // password

        Connection connection = DriverManager.getConnection(url, username, password); // 1- connection adımı

        Statement statement = connection.createStatement(); // sorguları calıstırmak için page açıldı, (statement = sorgu)

        ResultSet rs = statement.executeQuery("select * from actor"); //(rs = result set , sorgu sonucu) // sorgu sonucu olustu henüz db de bekliyor


        // ilk satır
        rs.next();
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // ikinci satır
        rs.next();
        firstName = rs.getString("first_name");
        lastName = rs.getString("last_name");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        connection.close();



    }


}
