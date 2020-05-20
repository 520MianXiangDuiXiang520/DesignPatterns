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
