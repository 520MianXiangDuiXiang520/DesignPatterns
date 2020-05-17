package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.fitting.camera.BaseCamera;

public abstract class BasePhone {
    BaseCPU cpu;
    BaseCamera camera;

    BasePhone(BaseCPU cpu, BaseCamera camera) {
        this.cpu =  cpu;
        this.camera = camera;
    }

    public void printConfig() {
        System.out.println("CPU: " + cpu.name + " Camera: " + camera.brand + " " + camera.pixel);
    }
}
