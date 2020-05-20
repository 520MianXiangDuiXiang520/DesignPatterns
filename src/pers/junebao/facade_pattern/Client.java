package pers.junebao.facade_pattern;

public class Client {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = ShoppingFacade.createShoppingFacade();
        shoppingFacade.buy(new Goods("口罩"));
    }
}
