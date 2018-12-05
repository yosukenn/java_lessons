public class Main {
  public static void main(String[] args) {
    // FuncListクラスが持つメソッドを関数として変数に格納し、呼び出す
    // 格納
    Func1 func1 = FuncList::isOdd;
    // 呼び出し
    int i = 2;
    if (func1.judge(i)) {
      System.out.println(i + "は奇数です");
    } else {
      System.out.println(i + "は偶数です");
    }
    // 格納
    FuncList funcList = new FuncList();
    Func2 func2 = funcList::addNamePrefix;
    // 呼び出し
    String name1 = func2.addPrefix(true, "田中");
    String name2 = func2.addPrefix(false, "西野");
    System.out.println(name1);
    System.out.println(name2);
  }
}
