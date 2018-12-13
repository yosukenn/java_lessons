public class Bank {
  private String name; // 銀行名（必ず３文字以上が設定される）
  private String getName(); {
    return this.name;
  }
  public void setName(String newName) {
    if (newName.length() <= 3) {
      throw new IlleagalArgumentException("名前が不正です");
    }
    this.name = newName;
  }
}
