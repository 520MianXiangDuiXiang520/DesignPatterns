package pers.junebao.prototype_pattern;

public class Main {
    public static void main(String[] args) {
        Resume resume = new Resume("JuneBao");
        resume.setSex("男");
        resume.setEducation("本科");
        Resume resume1 = resume.clone();
        resume1.setSex("女");
        resume.print();
        resume1.print();
    }
}
