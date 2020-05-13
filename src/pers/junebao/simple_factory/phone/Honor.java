package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.CPU;
import pers.junebao.simple_factory.fitting.camera.Camera;

public class Honor extends Phone {
    public Honor(CPU cpu, Camera camera) {
        super(cpu, camera);
    }
}
