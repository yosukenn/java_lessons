import java.lang.reflect.*;

public class Launcher {
  // コマンドライン引数から、第一引数（起動すべきクラスのFQCN）、第二引数（起動仕方を示す文字；E, I）を受け取る
  public static void main(String[] args) throws ClassNotFoundException {
    // 現在のメモリ使用量を表示する
    long f1 = Runtime.getRuntime().freeMemory(); // 残りのメモリ容量
    long t1 = Runtime.getRuntime().totalMemory(); // 残りのメモリ総容量
    System.out.println("現在のメモリ使用量");
    System.out.println(t1 - f1 + "バイト");

    // FQCNのクラスが持つ、全てのメソッド名を画面に表示する
    Class<?> clazz = Class.forName(args[0]);
    Method[] methods = clazz.getDeclaredMethods();
    System.out.println(clazz.getName() + "のメソッド一覧");
    for (Method m : methods) {
      System.out.println(m.getName());
    }

    /* コマンドライン第２引数によって次のように起動する
    * ・Eの場合：ProcessBuilderで別プロセスとして起動する
    * ・Iの場合：リフレクションでmainメソッドを呼び出す
    */
    // if (args[1].equals("E")) {
    //   ProcessBuilder pb = new ProcessBuilder(
    //
    //   );
    // } else if (args[1].equals("I")) {
    //
    // }

    // 現在のメモリ使用量（MB単位）を表示する
    double f2 = Runtime.getRuntime().freeMemory(); // 残りのメモリ容量
    double t2 = Runtime.getRuntime().totalMemory(); // 残りのメモリ総容量
    System.out.println("現在のメモリ使用量");
    System.out.println((t2 - f2) / 1000000 + "MB");

    // このプログラムが終了する際には、起動に成功した場合は0、そうでなければ1を終了コードとする
  }
}
