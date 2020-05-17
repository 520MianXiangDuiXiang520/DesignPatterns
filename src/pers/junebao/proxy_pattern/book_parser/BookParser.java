package pers.junebao.proxy_pattern.book_parser;

public class BookParser implements IParser {
    private String book;
    private int pages;
    BookParser(String bookString) {
        book = bookString;
        // 计算pages,非常耗时....
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pages = 10000;
    }

    public int numberOfPages() {
        return this.pages;
    }
}
