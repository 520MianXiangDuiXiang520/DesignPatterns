package pers.junebao.template_method.exam;

public class Trump extends ExaminationPaper {
    @Override
    String result1() {
        return "能！";
    }

    @Override
    String result2() {
        return "不会！";
    }
}
