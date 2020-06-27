package pers.junebao.composite_pattern.struct.open_pattern;

/**
 * @author junebao
 */
public interface Component {
    /**
     * 所有同类对象都具有的方法
     */
    void showName();

    /**
     * 添加一个子节点，在透明模式中，这类方法会暴露给所有同类对象
     * @param c 要添加的子节点
     */
    void addChild(Component c);

    /**
     * 删除某个子节点
     * @param c 要删除的子节点
     */
    void delChild(Component c);
}
