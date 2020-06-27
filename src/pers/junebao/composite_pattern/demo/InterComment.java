package pers.junebao.composite_pattern.demo;

/**
 * @author Junebao
 */
public interface InterComment {
    /**
     * 展示评论
     */
    void showComment();

    /**
     * 回复评论
     * @param comment: 回复的 InterComment 对象
     */
    void reply(InterComment comment);
}
