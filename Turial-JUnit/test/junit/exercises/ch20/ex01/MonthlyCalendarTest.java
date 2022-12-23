package junit.exercises.ch20.ex01;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

/**
 * リスト20.1 システム時間を基準とし、月末までの日数を取得するメソッドとテストを作成する
 */

public class MonthlyCalendarTest {

    @Test
    public void 現在時刻が20120131の場合getRemainingDaysは0を返す() {
        MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 1, 31));
        assertEquals(sut.getRemainingDays(), 0);
    }

    @Test
    public void 現在時刻が20120130の場合getRemainingDaysは1を返す() {
        MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 1, 30));
        assertEquals(sut.getRemainingDays(), 1);
    }

    @Test
    public void 現在時刻が20120201の場合getRemainingDaysは28を返す() {
        MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 2, 1));
        assertEquals(sut.getRemainingDays(), 28);
    }

    private static Calendar newCalendar(int yyyy, int mm, int dd) {
    	// デフォルトの値としてこのメソッドが実行された時の日時の情報を取得しています。
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, yyyy);
        cal.set(Calendar.MONTH, mm - 1);
        cal.set(Calendar.DATE, dd);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }
}
