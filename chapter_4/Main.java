import java.util.*;
import java.time.*;

public class Main {
  public static void main(String[] args) {
    // インスタンスの等価判定の検証
    Set<Book> list1 = new HashSet<Book>();
    LocalDate now = LocalDate.now();
    Book b1 = new Book("桃太郎", now, "桃である。");
    list1.add(b1);
    System.out.println("要素数=" + list1.size());
    b1 = new Book("桃太郎", now, "桃である。"); // ただの条件
    list1.remove(b1);
    System.out.println("要素数=" + list1.size());

    // インスタンスの順序づけの検証
    List<Book> list2 = new ArrayList<>();
    Book book1 = new Book("浦島太郎", now.plusDays(10), "裏である。");
    Book book2 = new Book("金太郎", now.plusDays(40), "菌である");
    Book book3 = new Book("シンデレラ", now.plusDays(20), "シンである。");
    list2.add(book1);
    list2.add(book2);
    list2.add(book3);
    for (Book book : list2) {
      System.out.println(book.getTitle());
    }
    System.out.println("--------------------------");

    Collections.sort(list2);
    for (Book book : list2) {
      System.out.println(book.getTitle());
    }


  }
}
