package pers.junebao.factory_method;

import pers.junebao.factory_method.fitting.camera.LeicaFactory;
import pers.junebao.factory_method.fitting.cpu.KirinFactory;
import pers.junebao.simple_factory.fitting.camera.BaseCamera;
import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.phone.BasePhone;
import pers.junebao.simple_factory.phone.Honor;

public class HonorFactory implements IPhoneFactory {
    @Override
    public BasePhone createPhone() {
        BaseCPU cpu = new KirinFactory().createCPU();
        BaseCamera camera = new LeicaFactory().createCamera();
        return new Honor(cpu, camera);
    }
}
