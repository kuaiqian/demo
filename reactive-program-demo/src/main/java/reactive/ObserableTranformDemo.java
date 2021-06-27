package reactive;

import static reactive.RxJavaDemo.log;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.GroupedObservable;
import reactive.model.Student;

/**
 * @author FS001338
 * @date 2021/6/24
 */
public class ObserableTranformDemo {
    public static void main(String[] args) throws IOException {
        // buffer_demo();
        List<Student> students = generateTestData();
        // flatMap_demo(students);
        // groupby_demo(students);
        // map_demo(students);
        // scan_demo();
//        on_error_return_demo();
//        on_error_resume_next();
//        on_exception_resume_next();
        retry_demo();
    }

    private static void retry_demo() {
        Observable<Object> observable = Observable.create(s -> {
            for (int i = 0; i < 10; i++) {
                if (i == 7) {
//                    throw new Error("error");
                    throw new RuntimeException("my exception");
                }
                s.onNext(Integer.valueOf(i));
            }
        }).retry();
//        observable.retry();
//        observable.retry(1,e->{return true;});
        subscribe(observable);
        mainHanUp();
    }

    private static void on_exception_resume_next() {
        Observable<Integer> take = Observable.interval(1, TimeUnit.SECONDS).take(2).map(s-> Integer.valueOf(s.toString()));
        Observable<Object> observable = Observable.create(s -> {
            for (int i = 0; i < 10; i++) {
                if (i == 7) {
//                    throw new Error("error");
                    throw new RuntimeException("my exception");
                }
                s.onNext(Integer.valueOf(i));
            }
        }).onExceptionResumeNext(take);
        subscribe(observable);
        mainHanUp();
    }

    private static void on_error_resume_next() {
        Observable<Integer> take = Observable.interval(1, TimeUnit.SECONDS).take(2).map(s-> Integer.valueOf(s.toString()));
        Observable<Object> observable = Observable.create(s -> {
            for (int i = 0; i < 10; i++) {
                if (i == 7) {
                    throw new Error("error");
                }
                s.onNext(Integer.valueOf(i));
            }
        }).onErrorResumeNext(throwable -> {return take;});
        subscribe(observable);
        mainHanUp();
    }

    private static void on_error_return_demo() {
        Observable<Object> observable = Observable.create(s -> {
            for (int i = 0; i < 10; i++) {
                if (i == 7) {
                    throw new Error("error");
                }
                s.onNext(i);
            }
        }).onErrorReturn(e->e.getMessage());
        subscribe(observable);
    }

    private static void scan_demo() throws IOException {
        Observable<Long> scan = Observable.interval(1, TimeUnit.SECONDS).take(10).scan((sum, item) -> {
            return sum + item;
        });
        subscribe(scan);
        mainHanUp();
    }

    private static void mainHanUp() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void map_demo(List<Student> students) {
        Observable<String> observable = Observable.fromIterable(students).map(student -> {
            return student.getName();
        });
        subscribe(observable);
    }

    private static void groupby_demo(List<Student> students) {
        Observable<GroupedObservable<Integer, Student>> groupedObservableObservable =
            Observable.fromIterable(students).groupBy(student -> student.getSex());
        subscribe(groupedObservableObservable);
    }

    private static List<Student> generateTestData() {
        List courses = Lists.newArrayList("1化学", "1数学", "1语文");
        List courses1 = Lists.newArrayList("2英语", "2地理", "2历史");
        List courses2 = Lists.newArrayList("3音乐", "3数学", "3语文");
        List<Student> students = Lists.newArrayList(new Student("aa", 22, 1, courses),
            new Student("bb", 23, 1, courses1), new Student("cc", 24, 2, courses2));
        return students;
    }

    private static void flatMap_demo(List<Student> students) {
        Observable<Student> studentObservable = Observable.fromIterable(students);
        Observable<String> stringObservable = studentObservable.flatMap((student -> {
            return Observable.fromIterable(student.getCourse());
        }));
        subscribe(stringObservable);
    }

    private static void buffer_demo() {
        Observable<List<Integer>> buffer = Observable.range(1, 10).buffer(3);
        subscribe(buffer);
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
