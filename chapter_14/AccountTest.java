import org.junit.Test;
import static org.junit.Assert.*; // お決まりのimport文

public class AccountTest {
  // 実際にAccountをnewして使ってみるテスト   ＊mainメソッドは記述しない
  @Test public void instantiate() {   // テストメソッドには@Testをつける
    Account a = new Account("田中", 30000);
    assertEquals("田中", a.owner);
    assertEquals(30000, a.balance);
  }

  // 口座振込のメソッドテスト（正常系）
  @Test public void transfer() {
    Account a = new Account("齋藤", 30000);
    Account b = new Account("田中", 300);
    a.transfer(b, 20000);
    assertEquals(10000, a.balance);
    assertEquals(20300, b.balance);
  }
}

// 以下JUnitなしの単体テスト
/*
public class AccountTest {
  public static void main(String[] args) {
    testInstantiate();
    testTransfer();
  }

  // 実際にAccountをnewして使ってみるテスト
  private static void testInstantiate() {
    System.out.println("無事newできるかテストします");
    Account a = new Account("田中", 30000);
    if (!"田中".equals(a.owner)) {
      System.out.println("失敗！ 名義人がおかしい！");
    }
    if (30000 != a.balance) {
      System.out.println("失敗！ 残高がおかしい！");
    }
    System.out.println("テストを終了します");
  }

  private static void testTransfer() {

  }
}
*/
