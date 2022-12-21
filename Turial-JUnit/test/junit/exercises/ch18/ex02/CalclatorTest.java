package junit.exercises.ch18.ex02;

import org.junit.Test;

/**
 * リスト18.2 0で割る場合に例外が送出されることを検証するテストを作成する
 */
public class CalclatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void divideの第2引数に0を指定すると例外が発生する() throws Exception {
        Calculator sut = new Calculator();
        sut.divide(1, 0);
    }
}
