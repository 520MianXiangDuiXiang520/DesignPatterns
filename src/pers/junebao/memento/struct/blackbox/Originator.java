package pers.junebao.memento.struct.blackbox;


/**
 * @author JuneBao
 * @date 2020/6/1 0:24
 */
public class Originator {
    private class Memento implements MementoFlag{
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    private String state = "OFF";
    /**
     * 创建备忘录，保存当前状态
     * @return 返回保存了当前对象状态的备忘录对象
     */
    public MementoFlag createMemento(){
        return new Memento(this.state);
    }

    /**
     * @param memento 恢复 memento 中保存的对象状态
     */
    public void restoreByMemento(MementoFlag memento){
        this.state = ((Memento)memento).getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
