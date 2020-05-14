package pers.junebao.decorator_pattern.decorator;

import pers.junebao.decorator_pattern.Noodles;

public class AddSpicyStrips extends Burden{
    public AddSpicyStrips(Noodles noodles) {
        super(noodles);
        this.rawMaterial = noodles.rawMaterial + " ,辣条";
    }

    @Override
    public void sayWhoAmI() {
        System.out.println("我是加了辣条的烤冷面！！");
    }
}
