package junit.exercises.ch20.ex04;

/**
 * リスト20.4 認証クラス
 * @author shuji.w6e
 */
public class Authentication {

    AccountDao dao = null;

    public Accout authenticate(String userId, String password) {
        assert dao != null;
        Accout account = dao.findOrNull(userId);
        if (account == null) return null;
        return account.getPassword().equals(password) ? account : null;
    }
}