package pers.junebao.memento.struct.whitebox;

/**
 * @author JuneBao
 * @date 2020/5/31 23:25
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        System.out.println(originator.getState());

        // 保存状态
        Memento memento = originator.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);

        // 修改状态
        originator.setState("ON");
        System.out.println(originator.getState());

        // 恢复状态
        originator.restoreByMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
