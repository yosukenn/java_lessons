import org.junit.Test;
import static org.junit.Assert.*; // お決まりのimport文

public class AccountTest {
  // 実際にAccountをnewして使ってみるテスト   ＊mainメソッドは記述しない
  @Test public void instantiate() {   // テストメソッドには@Testをつける
    Account a = new Account("田中", 30000);
    assertEquals("田中", a.owner);
    assertEquals(30000, a.balance);
  }

  @Test public void transfer() {

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
