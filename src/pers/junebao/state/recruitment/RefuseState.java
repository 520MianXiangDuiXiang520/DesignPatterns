package pers.junebao.state.recruitment;

/**
 * @author JuneBao
 * @date 2020/5/26 18:19
 */
public class RefuseState implements IState {
    @Override
    public void header(Context context) {
        System.out.println("已回绝！！");
    }
}
