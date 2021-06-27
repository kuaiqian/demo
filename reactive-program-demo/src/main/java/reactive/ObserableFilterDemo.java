package reactive;

import static reactive.RxJavaDemo.log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import reactive.model.Student;

/**
 * @author FS001338
 * @date 2021/6/24
 */
public class ObserableFilterDemo {
    public static void main(String[] args) {
        // debounce_demo();
        List<Student> students = generateTestData();
        // distinct_demo(students);
        // elementAt_demo(students);
//        filter_demo();
//        first_demo();
//        sample_demo();
//        combine_demo();
        join_demo();
    }

    private static void join_demo() {
        Observable<Long> take = Observable.interval(1, TimeUnit.SECONDS).take(10);
        Observable<Long> just = Observable.just(1L);
//        Observable<Object> join = take.join(just);
//        subscribe(join);
        mainHanUp();
    }

    private static void combine_demo() {
        Observable<Long> take = Observable.interval(1, TimeUnit.SECONDS).take(10);
        Observable<Long> just = Observable.just(1L);
        Observable<String> stringObservable = Observable.combineLatest(just, take, (s1, s2) -> s1 + "" + s2);
        subscribe(stringObservable);
        mainHanUp();
    }

    private static void sample_demo() {
        Observable<Long> sample = Observable.interval(1, TimeUnit.SECONDS).sample(2, TimeUnit.SECONDS);
        subscribe(sample);
        mainHanUp();
    }

    private static void first_demo() {
        Observable.just(1, 2, 3, 4, 5).take(1).subscribe(s->log(s));
        Observable.just(1,2,3,4).firstElement().subscribe(s->log(s));
        Observable.just(1,2,3,4).ignoreElements().subscribe(()->{
            log("onComplete");
        });
    }

    private static void filter_demo() {
        Observable<Integer> filter = Observable.just(1, 2, 22, 30, 5, 8).filter(s -> s > 10);
        subscribe(filter);
    }

    private static void elementAt_demo(List<Student> students) {
        Observable.fromIterable(students).elementAt(1).subscribe(student -> log(student));
    }

    private static void distinct_demo(List<Student> students) {
        Observable<Integer> distinct = Observable.just(1, 2, 3, 3, 2, 4).distinct();
        subscribe(distinct);
        log("======================");
        Observable<Student> distinct1 = Observable.fromIterable(students).distinct(student -> student.getSex());
        subscribe(distinct1);
        log("======================");
        Observable<Student> distinct2 =
            Observable.fromIterable(students).distinctUntilChanged(student -> student.getSex());
        subscribe(distinct2);
    }

    private static void debounce_demo() {
        Observable<Long> debounce = Observable.interval(4, TimeUnit.SECONDS).debounce(3, TimeUnit.SECONDS);
        subscribe(debounce);
        mainHanUp();
    }

    private static List<Student> generateTestData() {
        List courses = Lists.newArrayList("1化学", "1数学", "1语文");
        List courses1 = Lists.newArrayList("2英语", "2地理", "2历史");
        List courses2 = Lists.newArrayList("3音乐", "3数学", "3语文");
        List<Student> students = Lists.newArrayList(new Student("aa", 22, 1, courses),
            new Student("bb", 23, 2, courses1), new Student("cc", 24, 1, courses2), new Student("dd", 60, 1, courses2));
        return students;
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

    private static void mainHanUp() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
