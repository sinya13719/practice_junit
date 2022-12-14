package junit.tutorial;

//import static org.hamcrest.CoreMatchers.*;
//import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link Calculator}のテストクラス
 */

public class CalculatorTest {

	@Test
	public void multiplyで3と4の乗算結果が取得できる() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3, 4);
		 assertTrue(expected == actual);
	
	}
}
