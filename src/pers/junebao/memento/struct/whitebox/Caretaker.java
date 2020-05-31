package pers.junebao.memento.struct.whitebox;

/**
 * @author JuneBao
 * @date 2020/5/31 23:18
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
