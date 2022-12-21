package junit.exercises.ch18.ex06;

import java.util.concurrent.Executors;

/**
 * リスト18.6 BackgroundTaskクラス
 */
public class BackgroundTask {

    private final Runnable task;

    public BackgroundTask(Runnable task) {
        this.task = task;
    }

    public void invoke() {
        Executors.newSingleThreadExecutor().execute(task);
    }
}