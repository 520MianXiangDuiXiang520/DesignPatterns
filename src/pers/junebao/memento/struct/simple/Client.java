package pers.junebao.memento.struct.simple;

/**
 * @author JuneBao
 * @date 2020/6/1 0:47
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        System.out.println(originator.getState());

        // 保存状态
        originator.saveMemento();

        // 修改状态
        originator.setState("ON");
        System.out.println(originator.getState());

        // 恢复状态
        originator.restoreMemento();
        System.out.println(originator.getState());
    }
}
