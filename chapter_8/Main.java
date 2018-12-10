import java.util.*;
import org.apache.commons.lang3.builder.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Book b1 = new Book("桃太郎", new Date(), "昔々");
    Book b2 = new Book("浦島太郎", new Date(), "昔々");
    Book b3 = new Book("金太郎", new Date(), "昔々");
    List<Book> books = new ArrayList<>();
    books.add(b2);
    books.add(b3);
    books.add(b1);
    for ( Book book : books ) {
      System.out.println(book.getTitle());
    }

    Collections.sort(books);
    for ( Book book : books ) {
      System.out.println(book.getTitle());
    }
  }
}
