package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.CPU;
import pers.junebao.simple_factory.fitting.camera.Camera;

public class OnePlus extends Phone {

    public OnePlus(CPU cpu, Camera camera) {
        super(cpu, camera);
    }
}
