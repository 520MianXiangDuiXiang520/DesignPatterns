package pers.junebao.template_method.demo;

public class Student1 extends Template {
    @Override
    String writeName() {
        return "student1";
    }

    public static void main(String[] args) {
        new Student1().doHomework();
    }
}
