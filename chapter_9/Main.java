// 練習問題
import java.io.*;
import java.util.zip.GZIPOutputStream;

// 起動コマンド
// $ java Main [コピー元ファイルパス] [コピー先ファイルパス]
public class Main {
  public static void main(String[] args) {
    // コピー元ファイル名とコピー先ファイル名はJavaプログラムの起動パラメータとして指定する
    String inFile = args[0];
    String outFile = args[1];

    FileInputStream fis = null;
    GZIPOutputStream gos = null;
    try {
      fis = new FileInputStream(inFile);
      FileOutputStream fos = new FileOutputStream(outFile);
      // ファイルの書き込みは必ずバッファリングする
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      gos = new GZIPOutputStream(bos);

      int i = fis.read();
      while ( i != -1 ) {
        // ファイルを書き込む際、java.util.zip.GZIPOutputStreamを使って圧縮する
        gos.write(i);
        i = fis.read();
      }
      gos.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (fis != null) {
          fis.close();
        }
        if (gos != null) {
          gos.close();
        }
      } catch (IOException ee) {

      }
    }

  }
}
