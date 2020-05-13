package pers.junebao.simple_factory.fitting.cpu;

public abstract class BashCPU {
    public String name;

    BashCPU(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                '}';
    }
}
