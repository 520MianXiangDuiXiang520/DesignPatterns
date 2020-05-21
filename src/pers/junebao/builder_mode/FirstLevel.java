package pers.junebao.builder_mode;

public interface FirstLevel extends CalculateWagesBuilder {
    @Override
    default double calculateBaseWages(){
        return 8000;
    }
}
