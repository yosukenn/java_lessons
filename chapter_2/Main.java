import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

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
    System.out.println(day);
    // 取得した値に100を足した値をCalendarの「日」にセットします
    c.set(Calendar.DAY_OF_MONTH, day + 100);
    // Calendarの日付情報をDate型に変換します
    Date future = c.getTime();
    System.out.println(future);
    // SimpleDateFormatを用いて、指定された形式でDateインスタンスの内容を表示します
    SimpleDateFormat f = new SimpleDateFormat("西暦yyyy年MM月dd日");
    String s = f.format(future);
    System.out.println(s);
  }
}
