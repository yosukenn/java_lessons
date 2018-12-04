import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;

public class Main {
  public static void main(String[] args) {
    // 2 - 1
    // 現在の時刻をDate型で取得します
    Date now = new Date();
    // 取得した日時情報をCalendarにセットします
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    // Calenderから「日」の数値を取得します
    int day = c.get(Calendar.DAY_OF_MONTH);
    // 取得した値に100を足した値をCalendarの「日」にセットします
    c.set(Calendar.DAY_OF_MONTH, day + 100);
    // Calendarの日付情報をDate型に変換します
    Date future = c.getTime();
    // SimpleDateFormatを用いて、指定された形式でDateインスタンスの内容を表示します
    SimpleDateFormat f1 = new SimpleDateFormat("西暦yyyy年MM月dd日");
    String s1 = f1.format(future);
    System.out.println(s1);

    System.out.println("----------------------");

    // 2 - 2
    // 2 - 1 と同様の動作を行うプログラムをjava8以降で可能になったTime APIを用いて実装
    LocalDate d = LocalDate.now();　// 2018-12-04
    d = d.plusDays(100);
    DateTimeFormatter f2 = DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");
    String s2 = d.format(f2);
    System.out.println(s2);

  }
}
