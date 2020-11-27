package Javassist.Method2;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory {

    <T> T getProxy(Object target, InvocationHandler handler) throws Throwable;
}
