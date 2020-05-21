package pers.junebao.builder_mode;

public class Director {
    private CalculateWagesBuilder cwb;
    Director(CalculateWagesBuilder cwb){
        this.cwb = cwb;
    }

    public double calculate(){
        double baseWages = cwb.calculateBaseWages();
        System.out.println("基本工资： " + baseWages + " 元");
        double bonus = cwb.calculateBonus();
        System.out.println("奖金： " + bonus + " 元");
        double tax = cwb.calculateTax();
        System.out.println("税款： " + tax + " 元");
        return baseWages + bonus - tax;
    }
}
