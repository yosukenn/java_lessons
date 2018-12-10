import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // 10-1
    Reader fr = null;
    try {
      // プロパティファイル形式のデータを読み込む
      fr = new FileReader("pref.properties");
      Properties p = new Properties();
      p.load(fr);
      // aichi.capitalとaichi.foodの内容を「名古屋：味噌カツ」の形式で画面に表示する
      String aichiCapital = p.getProperty("aichi.capital");
      String aichiFood = p.getProperty("aichi.food");
      System.out.println(aichiCapital + " : " + aichiFood);
    } catch(IOException e) {
      System.out.println(e.getMessage());
    }  finally {
      try {
        if (fr != null) {
          fr.close();
        }
      } catch (IOException ee) {
        
      }
    }
  }
}
