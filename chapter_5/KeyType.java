enum KeyType {
  PADLOCK(1024L),
  BUTTON(10000L),
  DIAL(30000L),
  FINGER(1000000L);

  private long unlockNum;
  private KeyType(long unlockNum) { this.unlockNum = unlockNum; }
  public long getUncloclNum() { return this.unlockNum; }
}
