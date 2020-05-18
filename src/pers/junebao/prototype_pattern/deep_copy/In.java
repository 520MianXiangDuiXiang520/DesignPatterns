package pers.junebao.prototype_pattern.deep_copy;

import java.io.Serializable;


public class In implements Cloneable, Serializable {
    private String name;

    public In(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "In{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
