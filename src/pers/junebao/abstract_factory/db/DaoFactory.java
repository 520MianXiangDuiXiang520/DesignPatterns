package pers.junebao.abstract_factory.db;

public class DaoFactory {
    private static String db = "MySQL";
//    private static String db = "SQLServer";

    public static IUserDao getUserDao(){
        try {
            try {
                return (IUserDao) Class.forName("pers.junebao.abstract_factory.db." + db + "UserDao").newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
//        switch (db){
//            case "MySQL":
//                return new MySQLUserDao();
//            case "SQLServer":
//                return new SQLServerUserDao();
//            default:
//                return null;
//        }

    }

    public static IDepartDao getDepartDao(){
        try {
            try {
                return (IDepartDao) Class.forName("pers.junebao.abstract_factory.db." + db + "DepartDao").newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
//        switch (db){
//            case "MySQL":
//                return new MySQLDepartDao();
//            case "SQLServer":
//                return new SQLServerDepartDao();
//            default:
//                return null;
//        }
    }
}
