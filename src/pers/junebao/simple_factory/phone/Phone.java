package pers.junebao.simple_factory.phone;

import pers.junebao.simple_factory.fitting.CPU;
import pers.junebao.simple_factory.fitting.Camera;

public abstract class Phone {
    CPU cpu;
    Camera camera;

    Phone(CPU cpu, Camera camera) {
        this.cpu =  cpu;
        this.camera = camera;
    }

    public void printConfig() {
        System.out.println("CPU: " + cpu.name + " Camera: " + camera.brand + " " + camera.pixel);
    }
}