package pers.junebao.simple_factory;

import pers.junebao.simple_factory.fitting.*;
import pers.junebao.simple_factory.phone.Honor;
import pers.junebao.simple_factory.phone.OnePlus;
import pers.junebao.simple_factory.phone.Phone;

public class PhoneFactory {
    /**
     * 一个用来产生 Phone 对象的工厂方法
     * @param name 根据 name 产生不同的 Phone 的子类对象
     * @return 返回实例化后的对象，name 不匹配返回 null
     */
    public static Phone getPhone(String name) {
        if(name.toLowerCase().equals("oneplus")){
            CPU cpu = new Qualcomm();
            Camera camera = new Sony();
            return new OnePlus(cpu, camera);
        } else if (name.toLowerCase().equals("honor")) {
            CPU cpu = new Kirin();
            Camera camera = new Leica();
            return new Honor(cpu, camera);
        } else {
            return null;
        }
    }
}