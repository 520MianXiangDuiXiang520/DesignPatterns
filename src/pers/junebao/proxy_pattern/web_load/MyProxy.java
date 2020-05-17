package pers.junebao.proxy_pattern.web_load;

public class MyProxy implements IServer {
    private Server server;
    private String article, image;

    MyProxy(){
        // 只加载文章
        article = Server.loadArticle();
        image = "缩略图";
    }

    @Override
    public void showArticle() {
        System.out.println(this.article);
    }

    @Override
    public void showImage() {
        if(server == null)
            server = new Server();
        server.showImage();
    }

    @Override
    public void show() {
        System.out.println(article + ", " + image);
    }
}
