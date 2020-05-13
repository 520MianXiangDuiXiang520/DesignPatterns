package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.BashCPU;
import pers.junebao.simple_factory.fitting.camera.BashCamera;

public abstract class BashPhone {
    BashCPU cpu;
    BashCamera camera;

    BashPhone(BashCPU cpu, BashCamera camera) {
        this.cpu =  cpu;
        this.camera = camera;
    }

    public void printConfig() {
        System.out.println("CPU: " + cpu.name + " Camera: " + camera.brand + " " + camera.pixel);
    }
}
