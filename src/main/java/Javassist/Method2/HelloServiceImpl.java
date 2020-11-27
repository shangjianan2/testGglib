package Javassist.Method2;

import java.util.List;

public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String msg) {
        System.out.println("say");
    }

    @Override
    public String echo(String msg) {
        return null;
    }

    @Override
    public String[] getHobbies() {
        return new String[0];
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public List<User> getUser(String group, int age) {
        return null;
    }
}
