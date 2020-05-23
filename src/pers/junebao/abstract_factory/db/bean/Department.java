package pers.junebao.abstract_factory.db.bean;

public class Department {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }
}
