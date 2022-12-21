package junit.exercises.ch18.ex02;

/**
 * リスト18.3 Counterクラス
 */
public class Calculator {
	
	/**
	 * 割り算を行うメソッド
	 * 
	 * @param  int x
	 * @param  int y
	 * 
	 * @return int x / y
	 */

    public int divide(int x, int y) {
        if (y == 0) throw new IllegalArgumentException("y is null");
        return x / y;
    }
}
