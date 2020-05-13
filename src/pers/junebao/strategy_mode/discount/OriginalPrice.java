package pers.junebao.strategy_mode.discount;

public class OriginalPrice implements BaseDiscountStrategy {
    @Override
    public double preferentialAlgorithm(double money) {
        return money;
    }
}
