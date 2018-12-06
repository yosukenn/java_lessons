import java.util.*;
import java.time.*;

public class Book implements Comparable<Book>, Cloneable {
  private String title;
  private LocalDate publishDate;
  private String comment;

  Book(String title, LocalDate publishDate, String comment) {
    this.title = title;
    this.publishDate = publishDate;
    this.comment = comment;
  }

  public String getTitle() { return this.title; }
  public LocalDate getPublishDate() { return this.publishDate; }
  public String getComment() { return this.comment; }

  public void setTitle(String title) {
    this.title = title;
  }
  public void setPublishDate(LocalDate publishDate) {
    this.publishDate = publishDate;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }

  // 4 - 1
  // 書名と発行日が同じであれば等価なものと判定され、かつ、HashSetなどに格納しても正しく利用できる
  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null) return false;
    if (!(o instanceof Book)) return false;
    Book b = (Book) o;
    // if (!this.title.trim().equals(b.title.trim()) || !this.publishDate.equals(b.publishDate)) {
    //   return false;
    // }
    // return true;
    return this.title.trim().equals(b.title.trim()) || this.publishDate.equals(b.publishDate);
  }

  @Override
  public int hashCode() {
    int result = 37;
    result = result * 31 + title.hashCode();        // this.title.hashCode();ではないのはなぜ？以下のフィールドも同様
    result = result * 31 + publishDate.hashCode();
    result = result * 31 + comment.hashCode();
    return result;
  }

  // 4 - 2
  // Bookインスタンスを格納したコレクションに対して、「Collections.sort();」を飛び出すと、は後尾が古い順に並び替えられる
  @Override
  public int compareTo(Book obj) {
    if (this.publishDate.isBefore(obj.publishDate)) {
      return -1;
    }
    if (this.publishDate.isAfter(obj.publishDate)) {
      return 1;
    }
    return 0;
  }

  // 4 - 3
  // clone() を呼び出すと、深いコピーによる複製が行われる。
  @Override
  public Book clone() {
    Book result = new Book(this.title, this.publishDate, this.comment);
    return result;
  }
}
