// 5 - 1
// 金庫クラスに格納するインスタンスの型は、開発時には未定である
public class Strong<E> {
  // 金庫には、１つのインスタンスを保存できる必要がある
  private E instance;
  // put()でインスタンスを保存し、get()でインスタンスを取得できる
  public void put(E i) {
    this.instance = i;
  }
  // get()で取得する際、キャストを使わなくても格納前の型に代入できる
  public E get() {
    return this.instance;
  }
}
