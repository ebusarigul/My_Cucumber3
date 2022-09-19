package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void test1() throws SQLException {

        // next() : bir sonraki row (satır),
        // previous() : bir önceki row(satır),
        // absolute(4) : baştan itibaren 4.ROW a gider. direkt verilen row a gider
        // relative(4) : bulundugu noktadan 4 adım sonraki row a gider

        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10); // 10.satıra git
        String title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15); // 15.satıra git
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15); // sondan 15.satıra gider
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5); // en son bulundugun yerden 5 satır ileri
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5); // en son bulundugun yerden 5 satır geri
        title = rs.getString("title");
        System.out.println("title = " + title);





    }


}
