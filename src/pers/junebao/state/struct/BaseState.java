package pers.junebao.state.struct;

/**
 * @author JuneBao
 * @date 2020/5/25 21:08
 * @deprecated
 */
public abstract class BaseState {
    /**
     * 设置上下文 context 的下一状态
     * @param context 当前上下文对象
     */
    public abstract void header(Context context);
}
