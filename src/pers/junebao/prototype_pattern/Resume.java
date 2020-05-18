package pers.junebao.prototype_pattern;

import pers.junebao.prototype_pattern.deep_copy.DeepClone;

import java.io.Serializable;

public class Resume implements Cloneable, Serializable {
    private String name;
    private String education;
    private String sex;

    Resume(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public void print(){
        System.out.println("name: " + this.name);
        System.out.println("sex : " + this.sex);
        System.out.println("education: " + this.education);
    }

    @Override
    public Resume clone() {
        Resume resume = null;
        resume = (Resume) DeepClone.deepClone(this);
        return resume;
    }
}
