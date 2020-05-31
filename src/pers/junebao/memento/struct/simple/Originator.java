package pers.junebao.memento.struct.simple;


/**
 * @author JuneBao
 * @date 2020/6/1 0:42
 */
public class Originator {
    private String state = "OFF";
    private Memento memento;

    private class Memento {
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

    /**
     * 保存快照
     */
    public void saveMemento(){
        this.memento = new Memento(this.state);
    }

    /**
     * 根据快照恢复对象
     */
    public void restoreMemento(){
        if(this.memento == null){
            System.out.println("没有保存快照！！");
        } else {
            this.state = this.memento.getState();
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
