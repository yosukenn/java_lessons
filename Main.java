import java.util.*;
import java.time.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello world");

    LocalDate d1 = LocalDate.now();
    LocalDate d2 = d1;
    System.out.println(d1);
    System.out.println(d2);
    d1 = d1.plusDays(100);
    System.out.println(d1);
    System.out.println(d2);
  }
}
