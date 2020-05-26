package pers.junebao.state.recruitment;

/**
 * @author JuneBao
 * @date 2020/5/26 18:00
 */
public class Context {
    private IState state = new NewDeliveryStare();

    protected void setState(IState state) {
        this.state = state;
    }

    void header(){
        this.state.header(this);
    }
}
