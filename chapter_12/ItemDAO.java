import java.util.*;
import java.sql.*;

public class ItemDAO {
  public static ArrayList<Item> findByMinimumPrice(int price) {
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection con = null;
    ArrayList<Item> items = new ArrayList<>();
    try {
      con = DriverManager.getConnection("jdbc:h2:./db/rpgdb");
      con.setAutoCommit(false);

      // SQL送信
      PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ITEMS WHERE price > " + price);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        Item item = new Item();
        item.setName(rs.getString("name"));
        item.setPrice(rs.getInt("price"));
        item.setWeight(rs.getInt("weight"));
        items.add(item);
      }

      rs.close();
      pstmt.close();


      con.commit();
    } catch (SQLException e) {
      try {
        con.rollback();
      } catch (SQLException ee) {
        ee.printStackTrace();
      } finally {
        if (con != null) {
          try {
            con.close();
          } catch (SQLException eee) {
            eee.printStackTrace();
          }
        }
      }
    } finally {
      return items;
    }
  }
}
