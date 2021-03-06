package cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理-拦截器
 * <p>
 * Created by lxk on 2016/11/25
 */
public class MyInterceptor implements MethodInterceptor {
    private Object target;//目标类

    public MyInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 返回代理对象
     * 具体实现，暂时先不追究。
     */
    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);//回调函数  拦截器
        //设置代理对象的父类,可以看到代理对象是目标对象的子类。所以这个接口类就可以省略了。
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create();
    }

    /**
     * args 目标方法的参数
     * method 目标方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("aaaaa");//切面方法a();
        //。。。
        method.invoke(this.target, objects);//调用目标类的目标方法
        //。。。
        System.out.println("bbbbb");//切面方法f();
        return null;
    }
}
