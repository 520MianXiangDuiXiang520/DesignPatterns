package pers.junebao.composite_pattern.demo;

/**
 * @author JuneBao
 * @date 2020/6/27 23:23
 */
public class Client {
    public static void main(String[] args) {
        InterComment firstComment = new CanReplyComment("This comment allows reply", "2020-6-20");
        InterComment canReply = new CanReplyComment("This reply can reply", "2020-6-23");
        firstComment.reply(canReply);
        InterComment banReply = new BanReplyComment("This reply can not reply", "2020-6-24");
        firstComment.reply(banReply);
        InterComment canReply2 = new CanReplyComment("I can reply", "2020-6-24");
        canReply.reply(canReply2);
        banReply.reply(canReply2);
        firstComment.showComment();

        InterComment secondComment = new BanReplyComment("This comment can not reply", "2020-6-27");
        secondComment.reply(new CanReplyComment("xxx", "2020-6-27"));
        secondComment.showComment();

    }
}
