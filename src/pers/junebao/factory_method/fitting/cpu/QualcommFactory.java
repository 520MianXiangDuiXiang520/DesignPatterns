package pers.junebao.factory_method.fitting.cpu;

import pers.junebao.simple_factory.fitting.cpu.BaseCPU;
import pers.junebao.simple_factory.fitting.cpu.Qualcomm;

public class QualcommFactory implements ICPUFactory {
    @Override
    public BaseCPU createCPU() {
        return new Qualcomm();
    }
}
