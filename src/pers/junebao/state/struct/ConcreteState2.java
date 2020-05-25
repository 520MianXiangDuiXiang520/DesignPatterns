package pers.junebao.state.struct;

/**
 * @author JuneBao
 * @date 2020/5/25 21:21
 * @deprecated
 */
public class ConcreteState2 extends BaseState {
    @Override
    public void header(Context context) {
        System.out.println("当前状态2，即将转到状态1");
        context.setState(new ConcreteState1());
    }
}
