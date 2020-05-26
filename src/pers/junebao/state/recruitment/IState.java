package pers.junebao.state.recruitment;

/**
 * @author Junebao
 */
public interface IState {
    /**
     * 在某种状态下，系统具体应该做的事
     * @param context 当前的上下文对象，方便在具体实现中修改状态
     */
    void header(Context context);
}
