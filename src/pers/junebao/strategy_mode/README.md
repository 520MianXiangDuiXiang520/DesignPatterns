## 策略模式

> 参考：
>
> * [CSDN | 策略模式](https://blog.csdn.net/xingjiarong/article/details/50168853)
> * [百家号 | 策略模式](https://baijiahao.baidu.com/s?id=1638224488060180625&wfr=spider&for=pc)

如果某个系统需要不同的算法（如超市收银的优惠算法），那么可以把这些算法独立出来，使之之间可以相互替换，这种模式叫做策略模式，它同样具有三个角色：

1. 环境角色：使用策略的类
2. 抽象策略角色：策略共有的抽象类或接口
3. 具体策略角色：具体的策略的实现

### 策略模式的优缺点

优点：

1. 需要新的算法时，只需要拓展策略，而不需要修改原有代码，符合开闭原则。
2. 避免出现过多判断分支，提高代码可读性。
3. 算法间可方便的进行继承，替换。

缺点：

1. 客户端必须熟悉所有算法，并自行决定使用哪个策略
2. 策略模式将造成产生很多策略类，可以通过使用享元模式在一定程度上减少对象的数量。

### 适用场景

一个系统中有很多类，这些类之间只有**行为**表现不同时，可以使用策略模式，策略模式在实例化策略时可以配合使用简单工厂。

### 例：

比如一个收银系统，结算时有不同的优惠策略，如 九折， 五折，满100减10等，这些不同的优惠策略便是”具体策略角色“，而收银系统就是 ”环境角色“，还需要定义一个 ”抽象策略角色“：

```java
package pers.junebao.strategy_mode.discount;

// 抽象策略角色
public interface BaseDiscountStrategy {
    double preferentialAlgorithm(double money);
}

```

```java
package pers.junebao.strategy_mode.discount;

// 折扣优惠(具体策略角色)
public class Discount implements BaseDiscountStrategy {
    private double discount;
    public Discount(double discount) {
    // Discount(double discount) {
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

```

```java
package pers.junebao.strategy_mode.discount;

// 满减优惠(具体策略角色)
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

```

这样，环境角色就可以自己决定使用哪种策略而不用修改代码了

```java
package pers.junebao.strategy_mode;

import pers.junebao.strategy_mode.discount.BaseDiscountStrategy;
import pers.junebao.strategy_mode.discount.Discount;

public class CashRegisterSystem {
    public static void main(String[] args) {
        BaseDiscountStrategy ds = new Discount(0.9);
        double purchasingPrice = 1500;
        double amountsPayable = ds.preferentialAlgorithm(purchasingPrice);
        System.out.println(amountsPayable);
    }
}
```

对于这些具体策略，可以使用简单工厂，进一步屏蔽策略的具体细节

```java
package pers.junebao.strategy_mode.discount;

public class StrategyFactory {
    public static BaseDiscountStrategy getDiscountStrategy(String name) {
        BaseDiscountStrategy result = null;
        switch (name){
            case "九折":{
                result = new Discount(0.9);
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

```



```java
BaseDiscountStrategy ds = StrategyFactory.getDiscountStrategy("满1000减200");
```



