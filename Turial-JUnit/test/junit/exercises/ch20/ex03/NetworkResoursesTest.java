package junit.exercises.ch20.ex03;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

/**
 * リスト20.3 
 * ネットワーク上のリソースファイルを読み込み、文字列として返すloadメソッドを持つ。
 * ただし、ネットワークに接続し、InputStreamオブジェクトを生成する処理はNetworkLoaderクラスに定義する。
 * NetworkResoursesクラスのloadメソッドのテストを作成せよ。
 */
public class NetworkResoursesTest {

    @Test
    public void loadでネットワークから取得した文字列を返す() throws Exception {
        // SetUp
        String expected = "Hello World";
        NetworkLoader mockLoader = mock(NetworkLoader.class);
        when(mockLoader.getInput()).thenReturn(new ByteArrayInputStream(expected.getBytes()));
        NetworkResourses sut = new NetworkResourses();
        sut.loader = mockLoader;
        // Exercise
        String actual = sut.load();
        // Assertion
        assertEquals(actual, expected);
    }

}