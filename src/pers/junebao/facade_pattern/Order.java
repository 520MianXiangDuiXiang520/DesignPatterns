package pers.junebao.facade_pattern;

//@SuppressWarnings("all")
public class Order {
    String goodName;
    int price;
    int orderId;

    Order(){}

    Order(String name) {
        this.goodName = name;
        this.price = 100;
        this.orderId = this.hashCode();
    }

    @Override
    public String toString(){
        return this.goodName + " (" + this.price + ")  订单号：" + this.orderId;
    }

    /**
     * 模拟查询 name 商品的库存
     * @param name 商品名
     * @return 返回库存数
     */
    private synchronized int checkInventory(String name) {
        return 10;
    }

    /**
     * 模拟减库存操作
     * @param name 商品名
     * @return 返回修改后的库存数
     */

    private synchronized boolean lessInventory(String name) {
        // -- 操作
        return true;
    }

    public Order createOrder(String name) {

        // 查询库存
        int inventory = this.checkInventory(name);
        if(inventory <= 0)
            return null;
        // 减库存
        if(this.lessInventory(name)) {
            // 生成订单
            return new Order(name);
        }
        return null;

    }
}
