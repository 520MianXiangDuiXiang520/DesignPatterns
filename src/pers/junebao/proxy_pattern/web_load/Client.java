package pers.junebao.proxy_pattern.web_load;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IServer server = new MyProxy();
        server.show();
        DynamicProxy dynamicProxy = new DynamicProxy(new Server());
        IServer dp = (IServer) Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(),
                Server.class.getInterfaces(), dynamicProxy);
        dp.show();
    }
}
