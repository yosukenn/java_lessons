import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
  // Bankの名前に正常な値をsetするテスト（正常系）
  @Test public void testSetName_ok() {
    Bank bank = new Bank();
    bank.setName("大田原");
  }

  // Bankの名前に２文字の名前をsetするテスト（異常系）
  @Test(expected = IllegalArgumentException.class)
  public void testSetNameWithTwoChar() {
    Bank bank = new Bank();
    bank.setName("大田");
  }

  // Bankの名前にnullをsetするテスト（異常系）
  @Test(expected = NullPointerException.class)
  public void testSetNameWithNull() {
    Bank bank = new Bank();
    bank.setName(null);
    fail();
  }

  // コンパイル
  // $ javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar Bank.java BankTest.java

  // 実行
  // java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BankTest
}
