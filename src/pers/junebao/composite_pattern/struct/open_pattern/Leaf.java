package pers.junebao.composite_pattern.struct.open_pattern;

/**
 * @author JuneBao
 * @date 2020/6/27 22:44
 */
public class Leaf implements Component {
    @Override
    public void showName() {
        System.out.println("Leaf");
    }

    @Override
    public void addChild(Component c) {
        System.out.println("You Can't Use this method");
    }

    @Override
    public void delChild(Component c) {
        System.out.println("You Can't Use this method");
    }
}
