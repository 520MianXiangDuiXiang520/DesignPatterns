package pers.junebao.strategy_mode;

import pers.junebao.strategy_mode.discount.BaseDiscountStrategy;
import pers.junebao.strategy_mode.discount.StrategyFactory;

public class CashRegisterSystem {
    public static void main(String[] args) {
        BaseDiscountStrategy ds = StrategyFactory.getDiscountStrategy("满1000减200");
        double purchasingPrice = 1500;
        double amountsPayable = ds.preferentialAlgorithm(purchasingPrice);
        System.out.println(amountsPayable);
    }
}
