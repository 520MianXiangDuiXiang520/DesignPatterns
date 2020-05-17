package pers.junebao.proxy_pattern.web_load;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private IServer server;

    DynamicProxy(IServer server) {
        this.server = server;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置增强
        // 后置增强
        return method.invoke(server, args);
    }
}
