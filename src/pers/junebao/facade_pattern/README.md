## 外观模式

> 外观模式( Facade),为子系统中的一组接口提供一个一致的界面,此模式定义了一个高层接口,这个接口使得这一子系统更加容易使用。
>
> 参考：
>
> 1. [refactoringguru | facade](https://refactoringguru.cn/design-patterns/facade)
> 2. [CSDN | 设计模式（九）外观模式Facade（结构型）](https://blog.csdn.net/hguisu/article/details/7533759)
> 3. [CSDN | 外观模式 ( 概念 | 适用场景 | 优缺点 | 代码示例 )](https://blog.csdn.net/shulianghan/article/details/105339213)

### 什么是外观模式

为一些可能很复杂的子系统提供一个高层接口（facade),让facade与这些子系统交互，客户端只与facade交互，以此简化客户端操作，降低代码耦合度。

![UTOOLS1589902073493.png](http://yanxuan.nosdn.127.net/654f2dc293b1a92e28b10fefc49c4172.png)

### 适用场景

1. 子系统越来越复杂时，可以使用外观模式封装一些快捷的操作，让客户端只与Facade交互。

2. 当处理一个老旧的系统时，由于这些代码老旧且难以维护，可以使用外观模式将所有与原来系统的交互过程交给Facade，新的模块直接与Facade交互，简化操作，提高开发效率。

3. > 需要将子系统组织为多层结构时，可以使用外观模式； 创建外观来定义子系统中各层次的入口。 你可以要求子系统仅使用外观来进行交互， 以减少子系统之间的耦合

### 优缺点

> 优点：
>
> * 减少了系统的相互依赖
>
> * 提高了灵活性。不管系统内部如何变化，只要不影响到外观对象，任你自由活动
>
> * 提高了安全性。想让你访问子系统的哪些业务就开通哪些逻辑，不在外观上开通的方法，你就访问不到
>
> 缺点：
>
> * 不符合开不原则，修改很麻烦

### 例

网购下单的过程可能包括生成订单，支付， 创建物流等多个步骤，对客户端来说，很复杂， 所以可以使用外观模式建立一个购物的Facade,客户端只需要传递要购买的货物给Facade,Facade负责后续与订单，支付等子模块交互。

```java
package pers.junebao.facade_pattern;

public class ShoppingFacade {
    private final Order order;
    private final Pay pay;
    private final Logistics logistics;
    private static volatile ShoppingFacade sh;

    private ShoppingFacade(){
        order = new Order();
        pay = new Pay();
        logistics = new Logistics();
    }

    public static ShoppingFacade createShoppingFacade() {
        if(sh == null){
           synchronized (ShoppingFacade.class) {
               if(sh == null) {
                   sh = new ShoppingFacade();
               }
           }
        }
        return sh;
    }

    public void buy(Goods goods) {
        // 创建订单
        Order o = order.createOrder(goods.name);
        if(o == null){
            System.out.println("订单创建失败");
        } else {
            // 支付
            if(pay.successPay(o)){
                // 生成物流信息
                String logisticsInfo = logistics.createLogisticsInfo(o);
                System.out.println(o.goodName + " | " + logisticsInfo);
            } else {
                System.out.println("支付失败");
            }
        }
    }
}

```

* Facade一般定义为单例的

```java
public class Client {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = ShoppingFacade.createShoppingFacade();
        shoppingFacade.buy(new Goods("口罩"));
    }
}
```

### 外观与代理

外观和代理有些类似，都是把复杂的客户端操作分装在一起，但不同的是代理与它代理的对象都实现了相同的接口，所以代理可以和它代理的对象互换，同时在客户端看来，代理就是真实对象；但外观模式中Facade与子模块本身不存在必须的连接，客户端同样感知不到真实子系统的存在。