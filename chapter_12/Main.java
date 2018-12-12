import java.util.*;
// import java.sql.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("１円以上のアイテム一覧表を表示します");
    ArrayList<Item> items = ItemDAO.findByMinimumPrice(1);
    for (Item item : items) {
      System.out.printf("%10s%4d%4d\n", item.getName(), item.getPrice(), item.getWeight());
    }

    // 以下はItemsテーブルの作成、アイテム２点の登録
    /*
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection con = null;
    try {
      con = DriverManager.getConnection("jdbc:h2:./db/rpgdb");
      con.setAutoCommit(false);

      PreparedStatement pstmt1 = con.prepareStatement("CREATE TABLE   ITEMS " +
      "(id INTEGER not NULL, " +
      " name VARCHAR(255), " +
      " price INTEGER, " +
      " weight INTEGER, " +
      " PRIMARY KEY ( id ))");
      pstmt1.executeUpdate();
      pstmt1.close();
      con.commit();

      PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO ITEMS VALUES (?, ?, ?, ?)");
      pstmt2.setInt(1, 1);
      pstmt2.setString(2, "やくそう");
      pstmt2.setInt(3, 5);
      pstmt2.setInt(4, 2);
      int r1 = pstmt2.executeUpdate(); // 変更された行数を取得
      if (r1 != 0) {
        System.out.println(r1 + "項目を登録しました");
      } else {
        System.out.println("登録できませんでした");
      }
      con.commit();
      pstmt2.setInt(1, 2);
      pstmt2.setString(2, "どくけしそう");
      pstmt2.setInt(3, 7);
      pstmt2.setInt(4, 2);
      int r2 = pstmt2.executeUpdate();
      if (r2 != 0) {
        System.out.println(r2 + "項目を登録しました");
      } else {
        System.out.println("登録できませんでした");
      }
      con.commit();
      pstmt2.close();

    } catch (SQLException e) {
      try {
        con.rollback();
      } catch (SQLException ee) {
        ee.printStackTrace();
      }
    } finally {
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    */



  }
}
