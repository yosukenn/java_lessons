public class Main {
  public static void main(String[] args) {
    // 6 - 1
    // FuncListクラスが持つメソッドを関数として変数に格納し、呼び出す
    // 格納
    Func1 f1 = FuncList::isOdd;
    // 呼び出し
    int i = 2;
    if (f1.judge(i)) {
      System.out.println(i + "は奇数です");
    } else {
      System.out.println(i + "は偶数です");
    }
    // 格納
    FuncList funcList = new FuncList();
    Func2 f2 = funcList::addNamePrefix;
    // 呼び出し
    String name1 = f2.addPrefix(true, "田中");
    String name2 = f2.addPrefix(false, "西野");
    System.out.println(name1);
    System.out.println(name2);

    // 6 - 2
    // FuncListクラスの２つのメソッドの内容を、それぞれラムダ式で表現したものを、Func1とFunc2に代入する
    Func1 f3 = x -> { return (x % 2 == 1); };
    i = 3;
    if (f3.judge(i)) {
      System.out.println(i + "は奇数です");
    } else {
      System.out.println(i + "は偶数です");
    }

    Func2 f4 = (male, name) -> {
      if (male == true) { return "Mr." + name; }
      else { return "Ms." + name; }
    };
    String name3 = f4.addPrefix(true, "斎藤");
    String name4 = f4.addPrefix(false, "白石");
    System.out.println(name3);
    System.out.println(name4);
  }
}
