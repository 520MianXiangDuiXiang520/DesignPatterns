package pers.junebao.simple_factory.fitting.cpu;

public class CPUFactory {
    public static CPU getCPU(String name) {
        if(name.toLowerCase().equals("qualcomm")) {
            return new Qualcomm();
        } else if (name.toLowerCase().equals("kirin")) {
            return new Kirin();
        } else {
            return null;
        }
    }
}
