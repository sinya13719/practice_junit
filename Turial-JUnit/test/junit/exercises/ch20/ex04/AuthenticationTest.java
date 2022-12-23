package junit.exercises.ch20.ex04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * リスト20.4
 * あるアプリケーションのアカウント認証クラスを作成したい。
 * アカウント情報はデータベースに保存されており、AccountDaoインターフェースでAccountクラスとして
 * 取得できるように設計した。AccountDaoインターフェースを利用する認証クラスを作成し、
 * 認証メソッドのテストを作成せよ
 */
@RunWith(Enclosed.class)
public class AuthenticationTest {
    public static class アカウントが存在しない場合 {
        Authentication sut;
        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.dao = mock(AccountDao.class);
            when(sut.dao.findOrNull("user001")).thenReturn(null);
        }
        @Test
        public void authenticateはnullを返す() throws Exception {
        	assertEquals(sut.authenticate("user001", "pw123"), null);
        }
    }

    public static class アカウントが存在しパスワードが一致する場合 {
        Authentication sut;
        Accout account;
        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.dao = mock(AccountDao.class);
            account = new Accout("user001", "pw123");
            when(sut.dao.findOrNull("user001")).thenReturn(account);
        }
        @Test
        public void authenticateはaccountを返す() throws Exception {
        	assertEquals(sut.authenticate("user001", "pw123"), sameInstance(account));
        }
    }
    
    public static class アカウントが存在するがパスワードが一致しない場合 {
        Authentication sut;
        Accout account;
        @Before
        public void setUp() throws Exception {
            sut = new Authentication();
            sut.dao = mock(AccountDao.class);
            account = new Accout("user001", "PW999");
            when(sut.dao.findOrNull("user001")).thenReturn(account);
        }
        @Test
        public void authenticateはnullを返す() throws Exception {
        	assertEquals(sut.authenticate("user001", "pw123"), null);
        }
    }
}