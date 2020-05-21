package pers.junebao.builder_mode;

public interface SecondLevel extends CalculateWagesBuilder {
    @Override
    default double calculateBaseWages(){
        return 6000;
    }
}
