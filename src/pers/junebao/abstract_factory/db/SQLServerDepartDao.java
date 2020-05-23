package pers.junebao.abstract_factory.db;

import pers.junebao.abstract_factory.db.bean.Department;

public class SQLServerDepartDao implements IDepartDao {
    @Override
    public Department select(String name) {
        System.out.println("SQLServer查询部门");
        return null;
    }

    @Override
    public void insert(Department department) {
        System.out.println("SQLServer插入新部门");
    }
}
