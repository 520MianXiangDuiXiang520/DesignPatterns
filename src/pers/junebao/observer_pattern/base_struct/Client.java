package pers.junebao.observer_pattern.base_struct;

public class Client {
    public static void main(String[] args) {
        ConcreteObserver observer = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();
        subject.addObserver(observer);
        subject.noticeAll();
    }
}
