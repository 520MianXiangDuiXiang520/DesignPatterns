package pers.junebao.builder_mode;

public class Client {
    public static void main(String[] args) {
        double finalWages = new Director(new FirstLevelAClass()).calculate();
        System.out.println("一级A类员工 xxx 的最终工资为： " + finalWages + " 元");
    }
}
/*
基本工资： 8000.0 元
奖金： 545.5223999023438 元
税款： 2622.01669921875 元
一级A类员工 xxx 的最终工资为： 5923.505700683594 元
 */