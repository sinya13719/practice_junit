package junit.exercises.ch18.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * リスト18.1 文字列をスネークケース（すべて小文字で単語区切りがアンダースコア）に変換するメソッドのテストを行う
 */
public class StingUtilsTest {

	@Test
	    public void toSnakeCaseはスネークケースを返す_aaaの場合() {
			assertEquals(StringUtils.toSnakeCase("aaa"), "aaa");
	    }

	    @Test
	    public void toSnakeCaseはスネークケースを返す_HelloWorldの場合() {
	    	assertEquals(StringUtils.toSnakeCase("HelloWorld"), "hello_world");
	    }

	    @Test
	    public void toSnakeCaseはスネークケースを返す_practiceJunitの場合() {
	    	assertEquals(StringUtils.toSnakeCase("practiceJunit"), "practice_junit");
	    }

}
