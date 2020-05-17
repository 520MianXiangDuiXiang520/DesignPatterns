package pers.junebao.proxy_pattern.structure;

public class Client {
    public static void main(String[] args) {
        IServer iServer = new Proxy();
    }
}
