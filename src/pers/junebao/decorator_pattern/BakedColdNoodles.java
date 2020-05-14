package pers.junebao.decorator_pattern;

public class BakedColdNoodles extends Noodles {

    BakedColdNoodles() {
        this.rawMaterial = "面";  // 最原始的烤冷面，配料只有面
    }

    @Override
    public void sayWhoAmI() {
        System.out.println("我是普通烤冷面！");
    }
}
