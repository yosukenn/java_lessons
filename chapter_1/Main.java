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
  }

  // 1 - 3
  // (1) .*
  // (2) A[0-9]?
  // (3) U[A-Z]{3}
}
