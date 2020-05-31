package pers.junebao.memento.struct.whitebox;

/**
 * @author JuneBao
 * @date 2020/5/31 23:18
 */
public class Originator {
    private String state = "OFF";
    /**
     * 创建备忘录，保存当前状态
     * @return 返回保存了当前对象状态的备忘录对象
     */
    public Memento createMemento(){
        return new Memento(this.state);
    }

    /**
     * @param memento 恢复 memento 中保存的对象状态
     */
    public void restoreByMemento(Memento memento){
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
