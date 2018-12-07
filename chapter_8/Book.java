import java.util.*;
import org.apache.commons.lang3.builder.*;

public class Book implements Comparable<Book> {
  private String title;
  private Date publishDate;
  private String comment;

  public Book(String title, Date publishDate, String comment) {
    this.title = title;
    this.publishDate = publishDate;
    this.comment = comment;
  }

  // 署名と発行日とコメントが同じであれば等価なものと判定され、かつ、HashSetなどに格納しても正しく利用できる
  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  // Bookインスタンスを格納したコレクションに対して、「Collections.sort();」を呼び出すと、発行日が古い順に並び替えられる
  @Override
  public int compareTo(Book o) {
    return CompareToBuilder.reflectionCompare(this, o);
  }
}
