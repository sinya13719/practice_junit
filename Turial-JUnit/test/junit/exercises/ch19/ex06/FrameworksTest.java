package junit.exercises.ch19.ex06;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * リスト19.6 
 * あるWebアプリケーションフレームワークのサポート状況を把握したい。
 * そのため、各環境を引数として指定し、サポートされる組み合わせならばtrueを返すメソッドのテストを行う
 */
@RunWith(Theories.class)
public class FrameWorksTest {

    @DataPoints
    public static ApplicationServer[] APP_SERVER_PARAMS = ApplicationServer.values();
    @DataPoints
    public static Database[] DATABASE_PARAMS = Database.values();
    private static Map<String, Boolean> SUPPORTS = new HashMap<String, Boolean>();

    /**
     * "@BeforeClass" はテストクラスの処理ごとに実行される。
     * support.txtの内容を1行ずつ読み取り、HashMapに代入する
     * 
     * 
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        InputStream in = FrameWorksTest.class.getResourceAsStream("resources/support.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            for (;;) {
                String line = reader.readLine();
                if (line == null) break;
                String[] params = line.split("\\|");
                SUPPORTS.put(params[0] + "-" + params[1], Boolean.valueOf(params[2]));
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    @Theory
    public void isSupportはtrueを返す(ApplicationServer appServer, Database db) throws Exception {
        assumeTrue(isSupport(appServer, db));
        String desc = ", AppServer:" + appServer + ", DB:" + db;
        assertEquals(desc, Frameworks.isSupport(appServer, db), true);
    }

    @Theory
    public void isSupportはfalseを返す(ApplicationServer appServer, Database db) throws Exception {
        assumeTrue(!isSupport(appServer, db));
        String desc = ", AppServer:" + appServer + ", DB:" + db;
        assertEquals(desc, Frameworks.isSupport(appServer, db), false);
    }

    private boolean isSupport(ApplicationServer appServer, Database db) {
        return SUPPORTS.get(appServer.toString() + "-" + db.toString());
    }
}