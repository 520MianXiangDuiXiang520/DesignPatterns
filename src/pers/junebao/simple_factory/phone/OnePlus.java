package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.BashCPU;
import pers.junebao.simple_factory.fitting.camera.BashCamera;

public class OnePlus extends BashPhone {

    public OnePlus(BashCPU cpu, BashCamera camera) {
        super(cpu, camera);
    }
}
