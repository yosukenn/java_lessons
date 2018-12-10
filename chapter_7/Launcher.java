import java.lang.reflect.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Launcher {
  // コマンドライン引数から、第一引数（起動すべきクラスのFQCN）、第二引数（起動仕方を示す文字；E, I）を受け取る
  public static void main(String[] args) throws ClassNotFoundException {
    // 現在のメモリ使用量を表示する
    long f1 = Runtime.getRuntime().freeMemory(); // 残りのメモリ容量
    long t1 = Runtime.getRuntime().totalMemory(); // 残りのメモリ総容量
    System.out.println("現在のメモリ使用量");
    System.out.println(t1 - f1 + "バイト");

    // このプログラムが終了する際には、起動に成功した場合は0、そうでなければ1を終了コードとする
    try {
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
      if (args[1].equals("E")) {
        launchExternal(clazz);
      } else if (args[1].equals("I")) {
        launchInternal(clazz);
      } else {
        throw new IllegalArgumentException("起動に必要な引数が指定されていません。");
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }

    // 現在のメモリ使用量（MB単位）を表示する
    double f2 = Runtime.getRuntime().freeMemory(); // 残りのメモリ容量
    double t2 = Runtime.getRuntime().totalMemory(); // 残りのメモリ総容量
    System.out.println("現在のメモリ使用量");
    System.out.println((t2 - f2) / 1024 / 1024 + "MB");

    System.exit(0);
  }

  // 別プロセスとして起動するメソッド
  public static void launchExternal(Class<?> clazz) throws Exception {
    ProcessBuilder pb = new ProcessBuilder(
      "java", clazz.getName());
    Process proc = pb.start();
    InputStreamReader isr = new InputStreamReader(proc.getInputStream(), "UTF-8");
    BufferedReader reader = new BufferedReader(isr);
    StringBuilder builder = new StringBuilder();
    int c;
    while ((c = reader.read()) != -1) {
        builder.append((char)c);
    }
    System.out.println("result:\n" + builder.toString());
    System.out.println("Command return code: " + proc.waitFor());
  }

  // mainメソッドを呼び出すメソッド
  public static void launchInternal(Class<?> clazz) throws Exception {
    Method m = clazz.getMethod("main", String[].class); // 「メソッド名main, 引数にString[]クラスオブジェクトを持つメソッドを使う」
    String[] args = {};
    m.invoke(null, (Object)args);
  }

}