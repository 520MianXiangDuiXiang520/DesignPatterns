package pers.junebao.template_method.exam;

public  abstract class ExaminationPaper {
    abstract String result1();
    abstract String result2();
    public final void question1(){
        System.out.println("喝消毒液能不能杀死病毒？");
        System.out.println("result is : " + result1());
    }

    public final void question2(){
        System.out.println("怎么优雅的吃撒尿牛丸？");
        System.out.println("result is: " + result2());
    }
}
