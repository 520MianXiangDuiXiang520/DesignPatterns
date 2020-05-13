package pers.junebao.simple_factory;

import pers.junebao.simple_factory.phone.Phone;

public class Consumer {
    public static void main(String[] args) {
        Phone phone = PhoneFactory.getPhone("Honor");
        assert phone != null;
        phone.printConfig();
    }
}
