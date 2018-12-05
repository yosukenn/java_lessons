public class Main {
  public static void main(String[] args) {
    StrongBox<String> s = new StrongBox<>(KeyType.FINGER);
    s.put("こんにちは");
    System.out.println(s.get());
  }
}
