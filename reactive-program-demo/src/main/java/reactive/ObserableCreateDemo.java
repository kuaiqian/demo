package reactive;

import static reactive.RxJavaDemo.log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author FS001338
 * @date 2021/6/24
 */
public class ObserableCreateDemo {
    public static void main(String[] args) throws IOException {
        // create_demo();
//        just_demo();
         empty_never_error_demo();
        // from_demo();
        // interval_demo();
//        range_demo();
//        timer_demo();
    }

    private static void timer_demo() throws IOException {
        subscribe(Observable.timer(1,TimeUnit.SECONDS));
        System.in.read();
    }

    private static void range_demo() {
        subscribe(Observable.range(1,10).repeat(2));
    }

    private static void interval_demo() throws IOException {
        Observable<Long> interval =
            Observable.interval(0, 3, TimeUnit.SECONDS, Schedulers.from(ThreadPoolUtil.COMMON_POOL)).takeUntil(s -> {
                return s == 10;
            });

        subscribe(interval);
        // 主线程需要阻塞
        System.in.read();
    }

    private static void from_demo() {
        List<Integer> list = Lists.newArrayList(1, null, 3);
        subscribe(Observable.fromIterable(list));
        log("list======================");
        subscribe(Observable.fromArray(1, 2, 3));
        log("array======================");
        subscribe(Observable.fromCallable(() -> {
            return 123;
        }));
        log("callable======================");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("completableFuture");
            return "234";
        });
        subscribe(Observable.fromFuture(completableFuture, 2, TimeUnit.SECONDS));
        log("future======================");
    }

    private static void empty_never_error_demo() {
//        subscribe(Observable.empty());
        subscribe(Observable.never());
//        subscribe(Observable.error(new Error("error")));
    }

    private static void just_demo() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        subscribe(Observable.just(list));
        log("===================");
        Observable<Integer> just = Observable.just(1, 2, 3, 4, null);
        subscribe(just);
    }

    private static void create_demo() {
        Observable observable = Observable.create(new ObservableOnSubscribe() {

            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("aaa");
            }
        });

        subscribe(observable);
    }

    private static void subscribe(Observable observable) {
        observable.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                log("onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                log("onNext:" + o);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                log("onError:" + e.getMessage());
            }

            @Override
            public void onComplete() {
                log("onComplete");
            }
        });
    }
}
