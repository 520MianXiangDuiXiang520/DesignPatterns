package pers.junebao.observer_pattern.channel_subscription;

import java.util.Observable;
import java.util.Observer;

public class Customer implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println( o.getClass().getSimpleName() + " 发布新节目");
    }
}
