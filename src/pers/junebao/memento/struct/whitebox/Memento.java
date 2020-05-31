package pers.junebao.memento.struct.whitebox;

/**
 * @author JuneBao
 * @date 2020/5/31 23:18
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
