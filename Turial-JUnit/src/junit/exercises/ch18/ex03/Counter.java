package junit.exercises.ch18.ex03;

/**
 * リスト18.3 Counterクラス
 */
public class Counter {
    int count = 0;

    /**
     * インクリメントを行うメソッド
     * 
     * @return int ++count
     */
    public int increment() {
        return ++count;
    }
}