package pers.junebao.simple_factory;

import pers.junebao.simple_factory.phone.BashPhone;

public class Consumer {
    public static void main(String[] args) {
        BashPhone phone = PhoneFactory.getPhone("Honor");
        assert phone != null;
        phone.printConfig();
    }
}
