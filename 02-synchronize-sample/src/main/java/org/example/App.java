package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    private final int myAge;
    private final Logger logger = LoggerFactory.getLogger(App.class);

    public App(int age) {
        this.myAge = age;
    }


    public synchronized void show() {
        String ctn = Thread.currentThread().getName();


        logger.info("Thread {} func show called", ctn);
        try {
            TimeUnit.SECONDS.sleep(1);
            logger.info("your age is {}", myAge);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        logger.info("Thread {} func show exited", ctn);
    }

    /**
     * 这个例子说明了一个问题，那就是同步仅对同一个实例有效<br>
     * 可以看出tinkle和ivy，可以同时运行，而不存在互相依赖的问题<br>
     * 但是tinkle自己在主线程和子线程中，的确是存在锁的关系<br>
     * 也就是说，同一个实例，如果出现在不同线程中，那么就可以使用同步进行控制。<br>
     * 这样也的确是有些道理。毕竟不同的实例之间，的确是没有什么关系<br>
     * 如果是单例的话，那么这个同样成立。毕竟单例实际返回的都是同一个对象。
     *
     * @param args entry args
     */
    public static void main(String[] args) {

        App tinkle = new App(40);
        App ivy = new App(35);
        new Thread(tinkle::show, "second").start();
        new Thread(ivy::show, "third").start();
        tinkle.show();

    }
}
