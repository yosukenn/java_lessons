import java.util.*;
import java.time.*;

public class Main {
  public static void main(String[] args) {
    // インスタンスの等価判定の検証
    Set<Book> set = new HashSet<Book>();
    LocalDate now = LocalDate.now();
    Book b1 = new Book("桃太郎", now, "桃である。");
    set.add(b1);  // ここでb1の参照先のBookインスタンスがHashSetに格納される
    System.out.println("要素数=" + set.size()); // 1
    b1 = new Book("桃太郎", now, "桃である。");  // b1を等価で更新（参照先は変わる）
    set.remove(b1);                         // b1の参照先のインスタンスと等価なものを削除
    System.out.println("要素数=" + set.size());

    // インスタンスの順序づけの検証
    List<Book> list = new ArrayList<>();
    Book book1 = new Book("浦島太郎", now.plusDays(10), "裏である。");
    Book book2 = new Book("金太郎", now.plusDays(40), "菌である");
    Book book3 = new Book("シンデレラ", now.plusDays(20), "シンである。");
    list.add(book1);
    list.add(book2);
    list.add(book3);
    for (Book book : list) {
      System.out.println(book.getTitle());
    }
    System.out.println("--------------------------");

    Collections.sort(list);
    for (Book book : list) {
      System.out.println(book.getTitle());
    }

    // インスタンスの複製に感する検証
    Book book4 = book1.clone();
    book1.setPublishDate(now.minusDays(10));
    System.out.println("コピー元：" + book1.getPublishDate() + "/コピー先：" + book4.getPublishDate());
  }
}
