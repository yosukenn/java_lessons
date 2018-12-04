import java.util.*;

public class Main {
  public static void main(String[] args) {
    // 3 - 2
    // 勇者２名をHeroとしてインスタンス化してArrayListに格納
    Hero h1 = new Hero("斎藤");
    Hero h2 = new Hero("鈴木");
    List<Hero> heros = new ArrayList<Hero>();
    heros.add(h1);
    heros.add(h2);
    // １つずつ順番に取り出して名前を表示する
    Iterator<Hero> it = heros.iterator();
    while(it.hasNext()){
      Hero h = it.next();
      System.out.println(h.getName());
    }
  }
}
