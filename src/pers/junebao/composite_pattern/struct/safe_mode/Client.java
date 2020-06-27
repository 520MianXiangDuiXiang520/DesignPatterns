package pers.junebao.composite_pattern.struct.safe_mode;

/**
 * @author JuneBao
 * @date 2020/6/27 23:00
 */
public class Client {
    public static void main(String[] args) {
        Component l2 = new Leaf();
        Component l = new Leaf();
        BaseComposite root = new Composite();
        root.addChild(l);
        BaseComposite r = new Composite();
        root.addChild(r);
        r.addChild(l2);
        root.showName();
    }
}
