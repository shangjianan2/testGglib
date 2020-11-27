package Javassist.Method1;

public class MainTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        TargetObject proxy = (TargetObject)ProduceProxy.getProxy(TargetObject.class);
        proxy.business();
    }
}
