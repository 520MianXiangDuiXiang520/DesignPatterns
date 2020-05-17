package pers.junebao.factory_method;


import pers.junebao.factory_method.fitting.camera.SonyFactory;
import pers.junebao.factory_method.fitting.cpu.QualcommFactory;
import pers.junebao.simple_factory.fitting.camera.BaseCamera;
import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.phone.BasePhone;
import pers.junebao.simple_factory.phone.OnePlus;

public class OnePlusFactory implements IPhoneFactory {
    @Override
    public BasePhone createPhone() {
        BaseCPU cpu = new QualcommFactory().createCPU();
        BaseCamera camera = new SonyFactory().createCamera();
        return new OnePlus(cpu, camera);
    }
}
