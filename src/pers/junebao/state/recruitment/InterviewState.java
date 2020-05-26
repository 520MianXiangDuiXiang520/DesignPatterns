package pers.junebao.state.recruitment;

import java.util.Scanner;

/**
 * @author JuneBao
 * @date 2020/5/26 18:18
 */
public class InterviewState implements IState {
    private boolean interview(){
        System.out.println("面试是否合格（Y/N）：");
        String input = new Scanner(System.in).next();
        return "Y".equals(input) || "y".equals(input);
    }

    @Override
    public void header(Context context) {
        if(interview()){
            System.out.println("恭喜通过面试，即将发放offer!!");
            context.setState(new PassState());
        } else {
            System.out.println("未能通过面试！！");
            context.setState(new RefuseState());
        }
    }
}
