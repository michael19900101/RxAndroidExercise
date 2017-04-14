package ObserverJava;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/3/31.
 */
public interface Observable {

    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notifyObservers(String message);
}
