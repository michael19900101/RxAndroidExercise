package ObserverJava;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/3/31.
 */
public class LessonStart {

    public static void main(String[] args){

        Observable teather = new Teather();

        Observer xiaoming = new Student();
        xiaoming.setName("小明");
        Observer xiaohong = new Student();
        xiaohong.setName("小红");

        teather.attach(xiaoming);
        teather.attach(xiaohong);

        teather.notifyObservers("点名啦");
    }
}
