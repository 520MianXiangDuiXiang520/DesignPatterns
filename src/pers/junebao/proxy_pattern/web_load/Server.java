package pers.junebao.proxy_pattern.web_load;

public class Server implements IServer {
    private String article;
    private String image;

    public static String loadArticle() {
        return "article";
    }

    public static String loadImage() {
        try {
            // 模拟加载图片的耗时操作
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "image";
    }

    @Override
    public void showArticle() {
        System.out.println(this.article);
    }

    @Override
    public void showImage() {
        System.out.println(this.image);
    }

    Server(){
        this.article = loadArticle();
        this.image = loadImage();
    }

    @Override
    public void show() {
        System.out.println(article + ", " + image);
    }
}
