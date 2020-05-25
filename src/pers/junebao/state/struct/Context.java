package pers.junebao.state.struct;

/**
 * @author JuneBao
 * @date 2020/5/25 21:13
 * @deprecated
 */
public class Context {
    private BaseState state;

    Context() {
        // 设置初始状态
        this.state = new ConcreteState1();
    }

    public void setState(BaseState state) {
        this.state = state;
    }

    public BaseState getState(){
        return this.state;
    }

    public void run(){
        state.header(this);
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.run();
        context.run();
    }

}
