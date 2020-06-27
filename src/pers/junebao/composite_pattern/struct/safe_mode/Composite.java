package pers.junebao.composite_pattern.struct.safe_mode;

import java.util.ArrayList;

/**
 * @author JuneBao
 * @date 2020/6/27 22:53
 */
public class Composite extends BaseComposite {
    private ArrayList<Component> children = new ArrayList<>();
    @Override
    public void showName() {
        for (Component child : children) {
            child.showName();
        }
    }

    @Override
    void addChild(Component c) {
        children.add(c);
    }

    @Override
    void delChild(Component c) {
        children.remove(c);
    }
}
