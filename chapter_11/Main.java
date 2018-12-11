import java.io.*;
import java.net.*;

public class Main implements AutoCloseable {
  @Override
  public void close() throws IOException {
      System.out.println("SampleFileReader Close.");
  }

  public static void main(String[] args) {
    URL url = null;

    try {
      url = new URL("http://dokojava.jp");
    } catch(MalformedURLException e) {
      System.out.println(e.getMessage());
    }

    if (url != null) {
      try (InputStream is = url.openStream(); InputStreamReader isr = new InputStreamReader(is)) {
        int i = isr.read();
        while(i != -1) {
          System.out.print((char) i);
          i = isr.read();
        }
      } catch(IOException e) {
        System.out.println(e.getMessage());
      }
    }

  }
}
