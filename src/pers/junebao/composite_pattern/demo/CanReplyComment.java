package pers.junebao.composite_pattern.demo;

import java.util.ArrayList;

/**
 * @author JuneBao
 * @date 2020/6/27 23:13
 */
public class CanReplyComment implements InterComment {
    private String content;
    private String date;
    private ArrayList<InterComment> comments = new ArrayList<>();

    public CanReplyComment(String str, String date) {
        this.content = str;
        this.date = date;
    }
    @Override
    public void showComment() {
        System.out.println(this.content + "(" + this.date + ")");
        System.out.print("  ");
        for (InterComment comment : comments) {
            comment.showComment();
        }
    }

    @Override
    public void reply(InterComment comment) {
        comments.add(comment);
    }
}
