package pers.junebao.strategy_mode.discount;

public class StrategyFactory {
    public static BaseDiscountStrategy getDiscountStrategy(String name) {
        BaseDiscountStrategy result;
        switch (name){
            case "九折":{
                result = new Discount(0.9);
                break;
            }
            case "八折": {
                result = new Discount(0.8);
                break;
            }
            case "五折": {
                result = new Discount(0.5);
                break;
            }
            case "满100减10": {
                result = new FullReduction(100, 10);
                break;
            }
            case "满1000减200": {
                result = new FullReduction(1000, 200);
                break;
            }
            default:
                result = new OriginalPrice();
        }
        return result;
    }
}
