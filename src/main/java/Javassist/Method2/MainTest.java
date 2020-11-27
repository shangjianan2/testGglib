package Javassist.Method2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MainTest {
    public static void main(String[] args) throws Throwable {
        final HelloService target = new HelloServiceImpl();
        ProxyFactory factory = new JavassistProxyFactory();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //打印日志
                System.out.println("[before] The method " + methodName + " begins");
                Object result = null;
                try{
                    //前置通知
                    result = method.invoke(target, args);
                    //返回通知, 可以访问到方法的返回值
                    System.out.println(String.format("after method:%s execute", method.getName()));
                } catch (Exception e){
                    e.printStackTrace();
                    //异常通知, 可以访问到方法出现的异常
                }
                //后置通知. 因为方法可以能会出异常, 所以访问不到方法的返回值
                //打印日志
                System.out.println("[after] The method ends with " + result);
                return result;
            }
        };

        HelloService proxy = factory.getProxy(target, handler);
        System.out.println(proxy);

        proxy.say("ricky");
        proxy.echo("world");
        proxy.getHobbies();
        proxy.insert(new User());
        proxy.getUser();
        proxy.getUser("A", 23);
    }
}
