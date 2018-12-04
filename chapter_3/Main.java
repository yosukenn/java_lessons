import java.util.*;

public class Main {
  public static void main(String[] args) {
    // 3 - 2
    // 勇者２名をHeroとしてインスタンス化してArrayListに格納
    Hero h1 = new Hero("斎藤");
    Hero h2 = new Hero("鈴木");
    List<Hero> heros = List.of(h1, h2);
    // List<Hero> heros = new ArrayList<>();
    // heros.add(h1);
    // heros.add(h2);
    // １つずつ順番に取り出して名前を表示する
    Iterator<Hero> it = heros.iterator();
    while(it.hasNext()){
      Hero h = it.next();
      System.out.println(h.getName());
    }

    // 3 - 3
    // それぞれの勇者が倒した敵の数(3, 7)を勇者とペアでコレクションに格納
    Map<Hero, Integer> killboard = new HashMap<>();
    killboard.put(h1, 3);
    killboard.put(h2, 7);
    // １つずつ取り出し、指定のように画面表示してください
    for(Hero key : killboard.keySet()) {
      int defeatNum = killboard.get(key);
      System.out.println(key.getName() + "が倒した敵＝" + defeatNum);
    }
  }
}
