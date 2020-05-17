package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.fitting.camera.BaseCamera;

public class OnePlus extends BasePhone {

    public OnePlus(BaseCPU cpu, BaseCamera camera) {
        super(cpu, camera);
    }
}
