// 11-1
// java.net.URL クラスを使って指定のURLにある画像を取得し、所定の名前で自分のPCに保存する
import java.net.*;
import java.io.*;

public class GetImage {
  public static void main(String[] args) {
    URL url = null;
    try {
      url = new URL("http://dokojava.jp/favicon.ico");
    } catch(MalformedURLException e) {
      System.out.println(e.getMessage());
    }

    if (url != null) {
      try (BufferedInputStream bis = new BufferedInputStream(url.openStream()); BufferedOutputStream  bos = new BufferedOutputStream(new FileOutputStream("dj.ico"))) {
        int i = bis.read();
        while (i != -1) {
          bos.write((byte) i);
          i = bis.read();
        }
        bos.flush();
      } catch(IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
