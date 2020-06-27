package pers.junebao.composite_pattern.struct.open_pattern;

import java.util.ArrayList;

/**
 * @author JuneBao
 * @date 2020/6/27 22:45
 */
public class Composite implements Component {
    private ArrayList<Component> children = new ArrayList<>();
    @Override
    public void showName() {
        System.out.println("Composite");
    }

    @Override
    public void addChild(Component c) {
        children.add(c);
    }

    @Override
    public void delChild(Component c) {
        children.remove(c);
    }
}
