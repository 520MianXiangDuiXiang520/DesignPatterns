package pers.junebao.decorator_pattern.decorator;

import pers.junebao.decorator_pattern.Noodles;

public class AddEggs extends Burden {

    public AddEggs(Noodles noodles) {
        super(noodles);
        this.rawMaterial = noodles.rawMaterial + ", 鸡蛋";
    }


    @Override
    public void sayWhoAmI() {
        System.out.println("我是加了鸡蛋的烤冷面！！");
    }

}
