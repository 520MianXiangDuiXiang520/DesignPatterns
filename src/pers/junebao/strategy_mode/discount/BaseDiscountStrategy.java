package pers.junebao.strategy_mode.discount;

// 抽象策略角色
public interface BaseDiscountStrategy {
    double preferentialAlgorithm(double money);
}
