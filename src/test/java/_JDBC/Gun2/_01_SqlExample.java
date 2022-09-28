package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends JDBCParent {

    //last, first, getRow, getInt, getDouble

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from city");

        rs.last(); // sonuncu row a gider

        String id = rs.getString(1);
        System.out.println("id = " + id);

        int idInt = rs.getInt(1);
        System.out.println("idInt = " + idInt);


        String cityName = rs.getString(2);
        System.out.println("name = " + cityName);

        //    int nameInt = rs.getInt(2);
        //    System.out.println("nameInt = " + nameInt);

        // tipi uygun olan dönüşümle, mesela hepsini String olarak alabilirsin.
        // ancak tipi uygun olmayan mesela isimleri, int olarak zaten alınmaz.

        int kacinciSatir = rs.getRow(); // bulunan satırın kacıncı satır oldugunu verir
        // dolayısıyla bir sorgunun sonucunda toplamda kaç satır geldiğini
        // rs.last() dedikten sonra rs.getRow() ile alabilirim.


        rs.first(); // ilk satıra gider.


    }


}
