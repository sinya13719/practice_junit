package junit.exercises.ch20.ex01;

import java.util.Calendar;

/**
 * リスト20.1 MonthlyCalendarクラス
 */
public class MonthlyCalendar {

    private final Calendar cal;

    public MonthlyCalendar() {
        this(Calendar.getInstance());
    }

    MonthlyCalendar(Calendar cal) {
        this.cal = cal;
    }

    public int getRemainingDays() {
        return cal.getActualMaximum(Calendar.DATE) - cal.get(Calendar.DATE); 
    }

}