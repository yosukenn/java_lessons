// 5 - 1
// 金庫クラスに格納するインスタンスの型は、開発時には未定である
public class StrongBox<E> {
  // 金庫には、１つのインスタンスを保存できる必要がある
  private E instance;
  // get()メソッドが呼び出されるたびに回数をカウントする
  private static long count;
  // 鍵の種類によって、必要施錠回数を定める
  private long unlockNum;
  // 鍵の種類を示すフィールド
  private KeyType keyType;
  // 鍵の種類を受け取るコンストラクタ
  public StrongBox(KeyType keyType) {
    this.keyType = keyType;
    this.unlockNum = keyType.getUncloclNum();
    // switch(this.keyType) {
    //   case PADLOCK:
    //     this.unlockNum = 1024;
    //     break;
    //   case BUTTON:
    //     this.unlockNum = 10000;
    //     break;
    //   case DIAL:
    //     this.unlockNum = 30000;
    //     break;
    //   case FINGER:
    //     this.unlockNum = 1000000;
    //     break;
    // }
  }
  // put()でインスタンスを保存し、get()でインスタンスを取得できる
  public void put(E i) {
    this.instance = i;
  }
  // get()で取得する際、キャストを使わなくても格納前の型に代入できる
  // 各鍵が定める必要施錠回数に到達しない限り、nullを返す
  public E get() {
    if (count < this.unlockNum) {
      StrongBox.count++;
      return null;
    } else {
      StrongBox.count = 0;
      return this.instance;
    }
  }
}
