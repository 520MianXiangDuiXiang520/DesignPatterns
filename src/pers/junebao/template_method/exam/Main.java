package pers.junebao.template_method.exam;

public class Main {
    public static void main(String[] args) {
        ExaminationPaper trump = new Trump();
        ExaminationPaper bd = new SecondGrade();
        trump.question1();
        trump.question2();
        System.out.println("----------------");
        bd.question1();
        bd.question2();
    }
}
