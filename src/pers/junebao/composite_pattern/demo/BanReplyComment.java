package pers.junebao.composite_pattern.demo;

/**
 * @author JuneBao
 * @date 2020/6/27 23:20
 */
public class BanReplyComment implements InterComment {
    private String content;
    private String date;

    public BanReplyComment(String str, String date){
        this.content = str;
        this.date = date;
    }

    @Override
    public void showComment() {
        System.out.println(this.content + "(" + this.date + ")");
    }

    @Override
    public void reply(InterComment comment) {
        System.err.println("This comment is not allowed to reply");
    }
}
