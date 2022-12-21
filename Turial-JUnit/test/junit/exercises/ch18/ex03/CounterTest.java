package junit.exercises.ch18.ex03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト18.3 呼び出されるごとにインクリメントされ、副作用を持つクラスのテスト
 */
@RunWith(Enclosed.class)
public class CounterTest {
    public static class 初期状態の場合 {
        Counter sut;

        @Before
        public void setUp() {
            sut = new Counter();
        }

        @Test
        public void incrementで1が取得できる() {
        	assertEquals(sut.increment(), 1);
        }
    }

    public static class incrementが1回実行された場合 {
        Counter sut;

        @Before
        public void setUp() {
            sut = new Counter();
            sut.increment();
        }

        @Test
        public void incrementで2が取得できる() {
        	assertEquals(sut.increment(), 2);
        }
    }

    public static class incrementが50回実行された場合 {
        Counter sut;

        @Before
        public void setUp() {
            sut = new Counter();
            for (int i = 0; i < 50; i++)
                sut.increment();
        }

        @Test
        public void incrementで51が取得できる() {
        	assertEquals(sut.increment(), 51);
        }
    }
    
}