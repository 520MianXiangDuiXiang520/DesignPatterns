package pers.junebao.builder_mode;

import java.util.Random;

public interface ClassB extends CalculateWagesBuilder {
    default int getSales(){
        return new Random().nextInt() % 100;
    }

    @Override
    default double calculateBonus() {
        return getSales() * 20;
    }
}
