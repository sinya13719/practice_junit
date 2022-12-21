package junit.exercises.ch18.ex06;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * リスト18.6 タスクがバックグラウンドのスレッドで実行されることをテストする
 */
public class BackgroundTaskTest {

	@Rule
    public Timeout timeout = new Timeout(1000);

    @Test
    public void invokeで別スレッドで実行される() throws Exception {
        // SetUp
        final AtomicReference<String> backgroundThreadName = new AtomicReference<String>();
        final CountDownLatch latch = new CountDownLatch(1);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                backgroundThreadName.set(Thread.currentThread().getName());
                latch.countDown();
            }
        };
        BackgroundTask sut = new BackgroundTask(task); // Exercise
        sut.invoke();
        latch.await();
        // Verify
        assertTrue(backgroundThreadName.get() != Thread.currentThread().getName());
    }
}