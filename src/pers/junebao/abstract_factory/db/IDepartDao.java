package pers.junebao.abstract_factory.db;

import pers.junebao.abstract_factory.db.bean.Department;

public interface IDepartDao {
    Department select(String name);
    void insert(Department department);
}
