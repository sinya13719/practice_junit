package junit.exercises.ch19.ex04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


/**
 * リスト19.4 
 * 浮動小数点数の範囲を表すRangeクラスがあり、このクラスは浮動小数点数を指定して、
 * 範囲内であるかを判定するcontainメソッドが定義されている。そのメソッドのテストを行う。
 */
@RunWith(Enclosed.class)
public class RangeTest {

    @Test
    public void containsのテスト() {
        assertEquals(new Range(0d, 10.5).contains(-0.1), false);
        assertEquals(new Range(0d, 10.5).contains(0.0), true);
        assertEquals(new Range(0d, 10.5).contains(10.5), true);
        assertEquals(new Range(0d, 10.5).contains(10.6), false);
        assertEquals(new Range(-5.1, 5.1).contains(-5.2), false);
        assertEquals(new Range(-5.1, 5.1).contains(-5.1), true);
        assertEquals(new Range(-5.1, 5.1).contains(5.1), true);
        assertEquals(new Range(-5.1, 5.1).contains(5.2), false);
    }

    @RunWith(Enclosed.class)
    public static class Rangeが0から10_5で {
        @RunWith(Theories.class)
        public static class かつ範囲外の場合 {
            Range sut;

            @Before
            public void setUp() {
                sut = new Range(0d, 10.5);
            }

            @DataPoints
            public static double[] VALUES = { -0.1, 10.6 };

            @Theory
            public void containsはfalseを返す(double value) throws Exception {
                assertEquals("value=" + value, sut.contains(value), false);
            }
        }

        @RunWith(Theories.class)
        public static class かつ範囲内の場合 {
            Range sut;

            @Before
            public void setUp() {
                sut = new Range(0d, 10.5);
            }

            @DataPoints
            public static double[] VALUES = { 0, 10.5 };

            @Theory
            public void containsはtrueを返す(double value) throws Exception {
                assertEquals("value=" + value, sut.contains(value), true);
            }
        }
    }

}