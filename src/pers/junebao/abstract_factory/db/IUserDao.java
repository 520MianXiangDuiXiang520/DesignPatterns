package pers.junebao.abstract_factory.db;

import pers.junebao.abstract_factory.db.bean.User;

public interface IUserDao {
    void insert(User user);
    void select(String name);
}
