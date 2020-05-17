package pers.junebao.proxy_pattern.book_parser;

public class BookParserProxy implements IParser {
    private BookParser bp;
    private String book;

    BookParserProxy(String bookString) {
        this.book = bookString;
    }

    @Override
    public int numberOfPages() {
        if(bp == null) {
            bp = new BookParser(book);
        }
        return bp.numberOfPages();
    }
}
