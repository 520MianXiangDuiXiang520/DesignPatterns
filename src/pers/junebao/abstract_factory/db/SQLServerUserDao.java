package pers.junebao.abstract_factory.db;

import pers.junebao.abstract_factory.db.bean.User;

public class SQLServerUserDao implements IUserDao {
    @Override
    public void insert(User user) {
        System.out.println("使用SQLServer的插入方法把User插入表中");
    }

    @Override
    public void select(String name) {
        System.out.println("使用SQLServer中的查询方法查询name");
    }
}
