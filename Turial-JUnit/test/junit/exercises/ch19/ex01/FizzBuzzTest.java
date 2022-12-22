package junit.exercises.ch19.ex01;

import static junit.exercises.ch19.ex01.Lists.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * リスト19.1 １から指定された値までの値を文字列に変換し、リストとして返すクラスのテスト
 */
public class FizzBuzzTest {

    @Test
    public void createFizzBuzzListで16まで取得できる() {
        List<String> actual = FizzBuzz.createFizzBuzzList(16);
        assertTrue(actual.size() != 0);
        assertEquals(actual.size(), 16);
        assertEquals(actual.get(0), "1");
        assertEquals(actual.get(1), "2");
        assertEquals(actual.get(2), "Fizz");
        assertEquals(actual.get(3), "4");
        assertEquals(actual.get(4), "Buzz");
        assertEquals(actual.get(5), "Fizz");
        assertEquals(actual.get(6), "7");
        assertEquals(actual.get(7), "8");
        assertEquals(actual.get(8), "Fizz");
        assertEquals(actual.get(9), "Buzz");
        assertEquals(actual.get(10), "11");
        assertEquals(actual.get(11), "Fizz");
        assertEquals(actual.get(12), "13");
        assertEquals(actual.get(13), "14");
        assertEquals(actual.get(14), "FizzBuzz");
        assertEquals(actual.get(15), "16");
    }

    @Test
    public void createFizzBuzzListで16まで取得できる2() {
        List<String> expected = new ArrayList<String>(16);
        expected.add("1");
        expected.add("2");
        expected.add("Fizz");
        expected.add("4");
        expected.add("Buzz");
        expected.add("Fizz");
        expected.add("7");
        expected.add("8");
        expected.add("Fizz");
        expected.add("Buzz");
        expected.add("11");
        expected.add("Fizz");
        expected.add("13");
        expected.add("14");
        expected.add("FizzBuzz");
        expected.add("16");
        List<String> actual = FizzBuzz.createFizzBuzzList(16);
        assertEquals(actual, expected);
    }

    @Test
    public void createFizzBuzzListで6まで取得できる() {
        List<String> actual = FizzBuzz.createFizzBuzzList(6);
        // assertThatメソッドが使用できないため、カスタムMatcherを引数に与えられないので、この処理は失敗する。
        assertEquals(actual, list("1", "2", "Fizz", "4", "Buzz", "Fizz"));
    }

}