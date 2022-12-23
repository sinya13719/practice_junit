package junit.exercises.ch20.ex02;

import java.io.IOException;
import java.util.Map;

/**
 * リスト20.2 LogLoaderを利用してログファイルを読み込み、ログファイルの解析を行う LogAnalyzerクラス
 */
public class LogAnalyzer {

    LogLoader logLoader = new LogLoader();

    public Object analyze(String file) {
        try {
            Map<String, String> rawData = logLoader.load(file);
            return doAnalyze(rawData);
        } catch (IOException e) {
            throw new AnalyzeException(e);
        }
    }

    private Object doAnalyze(Map<String, String> rawData) {
        // これは仮実装です
        return new Object();
    }

    static class AnalyzeException extends RuntimeException {
        public AnalyzeException(Throwable cause) {
            super(cause);
        }
    }
}