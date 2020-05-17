package pers.junebao.proxy_pattern.book_parser;

public class Client {
    public static void main(String[] args) {
        IParser bp = new BookParserProxy("xxxxxx");
        System.out.println(bp.numberOfPages());
        System.out.println(bp.numberOfPages());
    }
}
