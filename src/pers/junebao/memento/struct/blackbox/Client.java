package pers.junebao.memento.struct.blackbox;

/**
 * @author JuneBao
 * @date 2020/6/1 0:30
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        System.out.println(originator.getState());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("ON");
        System.out.println(originator.getState());

        originator.restoreByMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
