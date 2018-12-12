import java.sql.*;

// STEP 0 : 事前準備
public class JdbcSample {
  public static void main(String[] args) {
    try {
      Class.forName("org.h2.Driver"); // ドライバーのロード
    } catch (ClassNotFoundException e) {
      e.printStackTrace(); // ドライバjarが見つからない場合の処理
    }

    Connection con = null;
    try {
      // STEP 1 : データベースの接続
      con = DriverManager.getConnection("jdbc:h2:./db/rpgdb"); // Connectionインスタンスの作成 -> DBへの接続 JDBC urlの指定
      con.setAutoCommit(false); // 主導コミットモードに切替
      // STEP 2 : SQL送信処理


      con.commit(); // コミット
    } catch (SQLException e) {
      try {
        con.rollback();
      } catch (SQLException ee) {
        ee.printStackTrace();
      }
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
