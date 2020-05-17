package pers.junebao.factory_method;

import pers.junebao.simple_factory.phone.BasePhone;

public class Consumer {
    public static void main(String[] args) {
        BasePhone onePlus = new OnePlusFactory().createPhone();
        onePlus.printConfig();
        BasePhone honor = new HonorFactory().createPhone();
        honor.printConfig();
    }
}
