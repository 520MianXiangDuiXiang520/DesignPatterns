package pers.junebao.abstract_factory.db;

import pers.junebao.abstract_factory.db.bean.Department;

public class MySQLDepartDao implements IDepartDao {
    @Override
    public Department select(String name) {
        System.out.println("MySQL查询部门");
        return null;
    }

    @Override
    public void insert(Department department) {
        System.out.println("MySQL插入新部门");
    }
}
