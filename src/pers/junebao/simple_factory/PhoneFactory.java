package pers.junebao.simple_factory;

import pers.junebao.simple_factory.fitting.camera.BaseCamera;
import pers.junebao.simple_factory.fitting.camera.CameraFactory;
import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.fitting.cpu.CPUFactory;
import pers.junebao.simple_factory.phone.Honor;
import pers.junebao.simple_factory.phone.OnePlus;
import pers.junebao.simple_factory.phone.BasePhone;

public class PhoneFactory {
    /**
     * 一个用来产生 Phone 对象的工厂方法
     * @param name 根据 name 产生不同的 Phone 的子类对象
     * @return 返回实例化后的对象，name 不匹配返回 null
     */
    public static BasePhone getPhone(String name) {
        if(name.toLowerCase().equals("oneplus")){
            BaseCPU cpu = CPUFactory.getCPU("Qualcomm");
            BaseCamera camera = CameraFactory.getCamera("Sony");
            return new OnePlus(cpu, camera);
        } else if (name.toLowerCase().equals("honor")) {
            BaseCPU cpu = CPUFactory.getCPU("Kirin");
            BaseCamera camera = CameraFactory.getCamera("Leica");
            return new Honor(cpu, camera);
        } else {
            return null;
        }
    }
}
