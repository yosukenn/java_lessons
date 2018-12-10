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

    // 10-2
    // 総務部のリーダー「田中太郎（41歳）」のインスタンスをJVM内に生成した上で、直列化機構を使ってファイル「company.dat」に書き込むプログラムを作成せよ
    Employee taro = new Employee("田中太郎", 41);
    Department affairs = new Department("総務部", taro);
    ObjectOutputStream oos = null;
    try {
      FileOutputStream fos = new FileOutputStream("company.dat");
      oos = new ObjectOutputStream(fos);
      oos.writeObject(affairs);
      oos.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (oos != null) {
          oos.close();
        }
      } catch(IOException ee) {
        
      }
    }
  }
}
