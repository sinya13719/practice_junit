package junit.exercises.ch18.ex01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {
    
	/**
	 * リスト18.1 文字列をスネークケース（すべて小文字で単語区切りがアンダースコア）に変換するメソッド
	 * 
	 * @param   String text
	 * 
	 * @return  置換された文字列
	 */
    public static String toSnakeCase(String text) {
        if (text == null) throw new NullPointerException("text == null.");
        String snake = text;
        Pattern p = Pattern.compile("([A-Z])");
        for (;;) {
            Matcher m = p.matcher(snake);
            if (!m.find()) break;
            snake = m.replaceFirst("_" + m.group(1).toLowerCase());
        }
        return snake.replaceFirst("^_", "");
    }
}