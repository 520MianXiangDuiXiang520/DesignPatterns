package pers.junebao.observer_pattern.channel_subscription;

import java.util.Observable;

public class CCTV1 extends Observable {
    public void release(){
        this.setChanged();
        this.notifyObservers();
    }
}
