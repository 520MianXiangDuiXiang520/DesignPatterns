package pers.junebao.simple_factory.fitting.cpu;

public abstract class CPU {
    public String name;

    CPU(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                '}';
    }
}
