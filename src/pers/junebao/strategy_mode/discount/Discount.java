package pers.junebao.strategy_mode.discount;

// 折扣优惠
public class Discount implements BaseDiscountStrategy {
    private double discount;
    Discount(double discount) {
        if(discount > 1)
            discount = 1;
        else if(discount < 0)
            discount = 0.1;
        this.discount = discount;
    }

    @Override
    public double preferentialAlgorithm(double money) {
        return money * this.discount;
    }
}
