package pers.junebao.state.recruitment;

/**
 * @author JuneBao
 * @date 2020/5/26 18:25
 */
public class PassState implements IState {
    @Override
    public void header(Context context) {
        System.out.println("恭喜您已通过所有考核！！！");
    }
}
