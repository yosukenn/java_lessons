public class Main {
  public static void main(String[] args) {
    StrongBox<String> s = new StrongBox<>(KeyType.FINGER);
    s.put("こんにちは");
    String hello = s.get();
    System.out.println(hello);
  }
}
