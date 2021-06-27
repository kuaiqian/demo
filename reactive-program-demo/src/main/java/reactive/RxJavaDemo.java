package reactive;

import io.reactivex.Observable;

/**
 * @author FS001338
 * @date 2021/6/23
 */
public class RxJavaDemo {

    public static void main(String[] args) {
        Observable<Object> observable1 = Observable.create(s -> {
            new Thread(() -> {
                s.onNext(getStrData());
                s.onComplete();
            }).start();
        });

        Observable<Object> observable2 = Observable.create(s -> {
            // s.onError(new RuntimeException("error"));
        });
        Observable.merge(observable1, observable2).subscribe(s -> {
            log(s);
        }, Throwable::printStackTrace);
    }

    public static void log(Object s) {
        System.out.println(Thread.currentThread().getName() + "===>" + s.toString());
    }

    static String getStrData() {
        return "123";
    }
}
