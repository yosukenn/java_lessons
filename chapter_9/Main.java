// 練習問題
import java.io.*;
import java.util.zip.GZIPOutputStream;
import java.nio.file.Files;

// 起動コマンド
// $ java Main [コピー元ファイルパス] [コピー先ファイルパス]
public class Main implements AutoCloseable {
  public static void main(String[] args) {
    // コピー元ファイル名とコピー先ファイル名はJavaプログラムの起動パラメータとして指定する
    String inFile = args[0];
    String outFile = args[1];

    try (FileInputStream fis = new FileInputStream(inFile);
         GZIPOutputStream gos = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)))) {

      int i = fis.read();
      while ( i != -1 ) {
        // ファイルを書き込む際、java.util.zip.GZIPOutputStreamを使って圧縮する
        gos.write(i);
        i = fis.read();
      }
      gos.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }

  @Override
    public void close() throws IOException {
        System.out.println("SampleFileReader Close.");
    }
}
