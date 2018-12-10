// 練習問題
import java.io.*;

// 起動コマンド
// $ java Main [コピー元ファイルパス] [コピー先ファイルパス]
public class Main {
  public static void main(String[] args) throws IOException {
    String inFile = args[0];
    String outFile = args[1];

    FileInputStream fis = new FileInputStream(inFile);
    FileOutputStream fos = new FileOutputStream(outFile);

    int i = fis.read();
    while ( i != -1 ) {
      char c = (char) i;
      fos.write(c);
      i = fis.read();
    }
    fos.flush();
    fos.close();
    fis.close();
  }
}
