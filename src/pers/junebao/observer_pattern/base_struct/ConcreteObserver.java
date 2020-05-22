package pers.junebao.observer_pattern.base_struct;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("更新了");
    }
}
