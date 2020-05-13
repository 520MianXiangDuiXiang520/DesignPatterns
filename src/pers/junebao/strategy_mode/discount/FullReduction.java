package pers.junebao.strategy_mode.discount;

// 满减优惠
public class FullReduction implements BaseDiscountStrategy {

    private double discountPrice;  //优惠金额
    private double baseline;  // 满减条件

    FullReduction(double baseline, double price) {
        this.baseline = baseline;
        this.discountPrice = price;
    }

    @Override
    public double preferentialAlgorithm(double money) {
        if(money >= this.baseline)
            money -= this.discountPrice;
        return money;
    }
}
