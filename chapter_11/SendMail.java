// 10-2
import java.net.*;
import java.io.*;

public class SendMail {
  public static void main(String[] main) {
    Socket sock = null;
    try {
      sock = new Socket("smtp.example.com", 60025);
    } catch (IOException ee) {
      System.out.println(ee.getMessage());
    }

    try (BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream())) {
      StringBuilder sb = new StringBuilder();
      sb.append("HELO example.com\r\n")
        .append("MAIL FROM: asaka@example.com\r\n")
        .append("RCPT TO: minato@example.com\r\n")
        .append("DATA\r\n")
        .append("From: asaka@example.com\r\n")
        .append("Subject: Please send me your RPG\r\n")
        .append("Hello minato. I would like to play your RPG.\r\n")
        .append("Could you please send it to me?\r\n")
        .append(".\r\n")
        .append("QUIT\r\n");
      String email = sb.toString();
      bos.write(email.getBytes());
      bos.write("\r\n".getBytes());
      bos.flush();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (sock != null) {
          sock.close();
        }
      } catch (IOException ee) {
        System.out.println(ee.getMessage());
      }
    }
  }
}
