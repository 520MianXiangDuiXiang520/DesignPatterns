package pers.junebao.template_method.exam;

public class SecondGrade extends ExaminationPaper {
    @Override
    String result1() {
        return "不能";
    }

    @Override
    String result2() {
        return "凉15分钟";
    }
}
