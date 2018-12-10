import java.io.*;

public class TextSample {
  public static void main(String[] args) throws IOException {
    // ファイルへの書き込み
    FileWriter fw = new FileWriter("rpgsave.txt", true);

    fw.write('A');
    fw.flush();
    fw.close();

    // ファイルの読み込み
    FileReader fr = new FileReader("rpgsave.txt");
    System.out.println("全てのデータを読んで表示します");
    int i = fr.read();
    while (i != -1) {
      char c = (char) i;
      System.out.println(c);
      i = fr.read();
    }
    System.out.println("ファイルの末尾に到達しました。");
    fr.close();

  }
}
