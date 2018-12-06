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
  // (1) 全ての文字列 .*
  // (2) 最初の１文字はA、2文字目は数字、３文字目は数字か無し A¥d{1, 2} A[0-9]{1,2}
  // (3) 最初の１文字はU、2~4文字目は英大文字 U[A-Z]{3}

  
}
