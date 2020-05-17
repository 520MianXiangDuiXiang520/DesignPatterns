package pers.junebao.simple_factory.fitting.cpu;

public abstract class BaseCPU {
    public String name;

    BaseCPU(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                '}';
    }
}
