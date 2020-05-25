package pers.junebao.simple_factory;

import pers.junebao.simple_factory.phone.BasePhone;

public class Consumer {
    public static void main(String[] args) {
        BasePhone phone = PhoneFactory.getPhone("Honor");
        assert phone != null;
        phone.printConfig();
    }
}
