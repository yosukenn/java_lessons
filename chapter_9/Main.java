// 練習問題
import java.io.*;
import java.util.zip.GZIPOutputStream;

// 起動コマンド
// $ java Main [コピー元ファイルパス] [コピー先ファイルパス]
public class Main {
  public static void main(String[] args) {
    String inFile = args[0];
    String outFile = args[1];

    FileInputStream fis = null;
    FileOutputStream fos = null;
    GZIPOutputStream gos = null;
    BufferedOutputStream bos = null;
    try {
      fis = new FileInputStream(inFile);
      fos = new FileOutputStream(outFile);

      gos = new GZIPOutputStream(fos);
      bos = new BufferedOutputStream(gos);

      int i = fis.read();
      while ( i != -1 ) {
        bos.write(i);
        i = fis.read();
      }
      fos.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (fis != null) {
          fis.close();
        }
        if (fos != null) {
          fos.close();
        }
      } catch (IOException ee) {

      }
    }

  }
}
