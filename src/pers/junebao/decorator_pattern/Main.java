package pers.junebao.decorator_pattern;

import pers.junebao.decorator_pattern.decorator.AddEggs;
import pers.junebao.decorator_pattern.decorator.AddSpicyStrips;

public class Main {
    public static void main(String[] args) {
        Noodles bcn = new BakedColdNoodles();
        Noodles bcnAddEgg = new AddEggs(bcn);
        bcnAddEgg.sayWhoAmI();
        System.out.println(bcnAddEgg.rawMaterial);
        Noodles bcnEggSpicyS = new AddSpicyStrips(bcnAddEgg);
        bcnEggSpicyS.sayWhoAmI();
        System.out.println(bcnEggSpicyS.rawMaterial);
    }
}
/*
我是加了鸡蛋的烤冷面！！
面, 鸡蛋
我是加了辣条的烤冷面！！
面, 鸡蛋 ,辣条
 */