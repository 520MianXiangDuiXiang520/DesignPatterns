package pers.junebao.state.struct;

/**
 * @author JuneBao
 * @date 2020/5/25 21:20
 * @deprecated
 */
public class ConcreteState1 extends BaseState {
    @Override
    public void header(Context context) {
        System.out.println("当前状态1，即将转到状态2");
        context.setState(new ConcreteState2());
    }
}
