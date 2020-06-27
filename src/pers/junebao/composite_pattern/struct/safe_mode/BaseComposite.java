package pers.junebao.composite_pattern.struct.safe_mode;

/**
 * @author JuneBao
 * @date 2020/6/27 22:51
 */
public abstract class BaseComposite implements Component {
    /**
     * 所有同类对象都具有的方法
     */
    @Override
    public abstract void showName();


    /**
     * 添加一个子节点，在透明模式中，这类方法会暴露给所有同类对象
     * @param c 要添加的子节点
     */
    abstract void addChild(Component c);

    /**
     * 删除某个子节点
     * @param c 要删除的子节点
     */
    abstract void delChild(Component c);
}
