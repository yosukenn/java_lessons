import java.io.*;

public class TextSample {
  public static void main(String[] args) throws IOException {
    // ファイルへの書き込み
    FileWriter fw = null;
    try {
      fw = new FileWriter("rpgsave.txt", true);

      fw.write('A');
      fw.flush();
    } catch(IOException e) {
      System.out.println("エラーです。");
    } finally {
      if (fw != null) {
        try {
          fw.close();   // close()は必ずfinallyブロックに書く
        } catch(IOException e2) {}
      }
    }

    // ファイルの読み込み
    FileReader fr = null;
    try {
      fr = new FileReader("rpgsave.txt");
      System.out.println("全てのデータを読んで表示します");
      int i = fr.read();
      while (i != -1) {
        char c = (char) i;
        System.out.println(c);
        i = fr.read();
      }
      System.out.println("ファイルの末尾に到達しました。");
    } catch(IOException e) {
      System.out.println("エラーです。");
    } finally {
      if (fr != null) {
        try {
          fr.close();   // close()は必ずfinallyブロックに書く
        } catch(IOException e2) {}
      }
    }

  }
}
