package pers.junebao.observer_pattern.base_struct;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
    private Set<Observer> observers = new HashSet<>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void delObserver(Observer observer){
        observers.remove(observer);
    }

    /**
     * 通知所有订阅者
     */
    void noticeAll() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
