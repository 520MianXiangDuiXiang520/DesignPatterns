package pers.junebao.abstract_factory.db;

import pers.junebao.abstract_factory.db.bean.User;

public class Client {
    public static void main(String[] args) {
        IFactor factor = new MySQLFactory();
        IUserDao userDao = factor.getUserDao();
        IDepartDao departDao = factor.getDepartDao();
        userDao.insert(new User("1", "张三"));
        userDao.select("张三");
        IUserDao userDao1 = DaoFactory.getUserDao();
        assert userDao1 != null;
        userDao1.select("lisi");
    }
}
