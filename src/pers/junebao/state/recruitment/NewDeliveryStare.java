package pers.junebao.state.recruitment;

import java.util.Scanner;

/**
 * @author JuneBao
 * @date 2020/5/26 18:13
 */
public class NewDeliveryStare implements IState {
    private boolean resumeApproval(){
        System.out.println("简历是否合格（Y/N）：");
        String input = new Scanner(System.in).next();
        return "Y".equals(input) || "y".equals(input);
    }

    @Override
    public void header(Context context) {
        if(resumeApproval()){
            System.out.println("恭喜通过简历评估，请等待面试...");
            context.setState(new InterviewState());
        } else {
            System.out.println("简历评估未通过！");
            context.setState(new RefuseState());
        }

    }
}
