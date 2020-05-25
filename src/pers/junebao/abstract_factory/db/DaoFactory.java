package pers.junebao.abstract_factory.db;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author lenovo
 */
public class DaoFactory {

    private static final Properties properties = new Properties();
    private static String pack;
    private static String db;
    private static final String filePath = "./src/pers/junebao/abstract_factory/db/setting.properties";

    public static IUserDao getUserDao(){

        try {
            properties.load(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pack = properties.getProperty("package");
        db = properties.getProperty("db");
        String userDaoName = properties.getProperty("userDaoClassName");
        System.out.println(pack + db + userDaoName);
        try {
            try {
                return (IUserDao) Class.forName(pack + db + userDaoName).newInstance();
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
            properties.load(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pack = properties.getProperty("package");
        db = properties.getProperty("db");
        String departDaoName = properties.getProperty("departDaoClassName");
        try {
            try {
                return (IDepartDao) Class.forName(pack + db + departDaoName).newInstance();
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
