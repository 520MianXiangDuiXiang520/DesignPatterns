package pers.junebao.memento.struct.blackbox;


/**
 * @author JuneBao
 * @date 2020/6/1 0:28
 */
public class Caretaker {
    private MementoFlag memento;

    public MementoFlag getMemento() {
        return memento;
    }

    public void setMemento(MementoFlag memento) {
        this.memento = memento;
    }
}
