package junit.exercises.ch19.ex06;

/**
 * リスト19.6 Frameworksクラス
 */
public class Frameworks {

    public static boolean isSupport(ApplicationServer appServer, Database db) {
        switch (appServer) {
        case GlassFish:
            return true;
        case Tomcat:
            return db == Database.MySQL;
        case JBoss:
            return db == Database.DB2 || db == Database.PostgreSQL;
        default:
            return false;
        }
    }

}