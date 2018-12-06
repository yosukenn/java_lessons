enum KeyType {
  PADLOCK(1024L),
  BUTTON(10000L),
  DIAL(30000L),
  FINGER(1000000L);

  private long unlockNum;
  // このファイルが読み込まれる段階で列挙子が呼び出す -> unlockNumが定義される
  private KeyType(long unlockNum) {
    this.unlockNum = unlockNum;
  }
  public long getUnclockNum() { return this.unlockNum; }
}
