package pers.junebao.simple_factory;

import pers.junebao.simple_factory.fitting.camera.BashCamera;
import pers.junebao.simple_factory.fitting.camera.CameraFactory;
import pers.junebao.simple_factory.fitting.cpu.BashCPU;
import pers.junebao.simple_factory.fitting.cpu.CPUFactory;
import pers.junebao.simple_factory.phone.Honor;
import pers.junebao.simple_factory.phone.OnePlus;
import pers.junebao.simple_factory.phone.BashPhone;

public class PhoneFactory {
    /**
     * 一个用来产生 Phone 对象的工厂方法
     * @param name 根据 name 产生不同的 Phone 的子类对象
     * @return 返回实例化后的对象，name 不匹配返回 null
     */
    public static BashPhone getPhone(String name) {
        if(name.toLowerCase().equals("oneplus")){
            BashCPU cpu = CPUFactory.getCPU("Qualcomm");
            BashCamera camera = CameraFactory.getCamera("Sony");
            return new OnePlus(cpu, camera);
        } else if (name.toLowerCase().equals("honor")) {
            BashCPU cpu = CPUFactory.getCPU("Kirin");
            BashCamera camera = CameraFactory.getCamera("Leica");
            return new Honor(cpu, camera);
        } else {
            return null;
        }
    }
}
