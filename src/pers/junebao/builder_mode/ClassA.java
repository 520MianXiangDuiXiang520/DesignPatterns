package pers.junebao.builder_mode;

import java.util.Random;

public interface ClassA extends CalculateWagesBuilder {

    // 模拟评分
    default float getScore() {
        return new Random().nextFloat();
    }

    @Override
    default double calculateBonus() {
        return 1000 * getScore();
    }
}
