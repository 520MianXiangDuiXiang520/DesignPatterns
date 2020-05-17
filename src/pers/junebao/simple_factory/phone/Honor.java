package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.fitting.camera.BaseCamera;

public class Honor extends BasePhone {
    public Honor(BaseCPU cpu, BaseCamera camera) {
        super(cpu, camera);
    }
}
