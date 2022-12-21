package junit.exercises.ch18.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト18.4 整数値を引数にもち、引数が偶数である場合に、trueを返すメソッドのテスト
 */
public class NumberUtilsTest {

    @Test
    public void isEvenは10でtrueを返す() throws Exception {
    	assertEquals(NumberUtils.isEven(10), true);
    }

    @Test
    public void isEvenは7でfalseを返す() throws Exception {
    	assertEquals(NumberUtils.isEven(7), false);
    }
}