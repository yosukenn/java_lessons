import java.sql.*;

// STEP 0 : 事前準備
public class JdbcSample {
  public static void main(String[] args) {
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection con = null;
    try {
      // STEP 2 : データベースの接続
      con = DriverManager.getConnection("jdbc:h2:./db/rpgdb");
      // STEP 3 : SQL送信処理



    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // STEP 3 : データベース接続の切断
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
