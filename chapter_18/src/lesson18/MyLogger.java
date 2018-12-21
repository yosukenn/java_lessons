package lesson18;

import java.io.*;

// ファイルを２中に開かないようにSingletonパターンを採用
public final class MyLogger { // 継承を禁止する final
	private static MyLogger theInstance; // 唯一のインスタンス保存用
	private BufferedWriter bw;
	// インスタンス化と同時に「../../texts/dummy.txt」ファイルを開く
	private MyLogger() { // private なコンストラクタ
		try {
			FileWriter fw = new FileWriter("data/dummy.txt", false);
			this.bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}
	
	// 引数で渡した文字列をファイルに書く log() メソッドを持つ
	public void log(String text) {
		try {
			this.bw.write(text);
			this.bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public static MyLogger getInstance() { // インスタンス取得用
		if (theInstance == null) {
			theInstance = new MyLogger();
		}
		return theInstance;
	}
	
	public void fileClose() {
		try {
			if (this.bw != null) {
				this.bw.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
}
