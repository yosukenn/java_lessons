import java.util.regex.Pattern;

public class Main {
  // 1 - 2
  static String fileNameFormatter(String folder, String file) {
    if (!folder.endsWith("/")) { // エスケープシーケンスとして「¥」が機能しない（「\」ならする）のはなぜか。
      folder += "/";
    }
    return folder + file;
  }

  public static void main(String[] args) {
    // 1 - 1
    StringBuilder sb = new StringBuilder();

    for(int i = 1; i <= 100; i++) {
      String num = String.format("%d,", i);
      sb.append(num);
    }

    String s = sb.toString();

    String[] a = s.split(",");

    System.out.println(fileNameFormatter("/format", "readme.txt"));

    // 1 - 3
    // (1) 全ての文字列 .*
    String str1 = "dmalfmlsa";
    String pattern1 = ".*";
    Pattern p1 = Pattern.compile(pattern1);
    boolean isFound1 = p1.matcher(str1).find();
    System.out.println(isFound1);

    // (2) 最初の１文字はA、2文字目は数字、３文字目は数字か無し A¥d{1, 2} A[0-9]{1,2}
    String str2 = "A022";
    String pattern2 = "A¥d{1,2}";
    Pattern p2 = Pattern.compile(pattern2);
    boolean isFound2 = p2.matcher(str2).find();
    System.out.println(isFound2);

    // (3) 最初の１文字はU、2~4文字目は英大文字 U[A-Z]{3}
    String str3 = "UJSK";
    String pattern3 = "U[A-Z]{3}";
    Pattern p3 = Pattern.compile(pattern3);
    boolean isFound3 = p3.matcher(str3).find();
    System.out.println(isFound3);
  }

}
