package ObserverJava;

import java.util.ArrayList;
import java.util.List;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/3/31.
 */
public class Student implements Observer {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void say(String message) {
        System.out.println(message + ":" + this.name + "到");
    }
}
