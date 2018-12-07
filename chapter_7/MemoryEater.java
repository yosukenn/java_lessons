// 起動テスト用
// $ java Launcher MemoryEater E or I
public class MemoryEater {
  public static void main(String[] args) {
    System.out.println("要素数1280000のlong型配列を確保します。");
    long[] eaterArray = new long[1280000];
    for (int i = 0; i < eaterArray.length; i++) {
      eaterArray[i] = i;
    }
  }
}
