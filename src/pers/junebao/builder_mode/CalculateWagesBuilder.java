package pers.junebao.builder_mode;

public interface CalculateWagesBuilder {
    double calculateBaseWages();
    double calculateBonus();
    default double calculateTax(){
        return (calculateBaseWages() + calculateBonus()) * 0.3;
    }
}
