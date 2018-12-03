public class Main {
  public static void main(String[] args) {
    // 1 - 1
    StringBuilder sb = new StringBuilder();

    for(int i = 1; i < 101; i++) {
      String num = String.format("%d,", i);
      sb.append(num);
    }

    String s = sb.toString();

    String[] a = s.split(",");

    // 1 - 2
    
  }
}
