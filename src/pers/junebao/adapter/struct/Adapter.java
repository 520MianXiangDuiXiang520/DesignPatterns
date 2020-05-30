package pers.junebao.adapter.struct;

/**
 * @author lenovo
 */
public class Adapter implements Target {
    private Give give;

    Adapter(Give give){
        this.give = give;
    }

    public void show() {
        give.show();
    }
}
