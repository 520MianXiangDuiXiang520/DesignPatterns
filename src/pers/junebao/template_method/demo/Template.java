package pers.junebao.template_method.demo;

public abstract class Template {
    abstract String writeName();

    public final void doHomework(){
        System.out.println("name: " + writeName());
        System.out.println("别人的作业 ");
    }
}
