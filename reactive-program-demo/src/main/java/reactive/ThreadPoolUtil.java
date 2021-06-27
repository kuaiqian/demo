package reactive;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author FS001338
 * @date 2021/6/24
 */
public class ThreadPoolUtil {

    /**
     * 推荐使用该公共线程池
     */
    public static ThreadPoolExecutor COMMON_POOL = new ThreadPoolExecutor(5, 20, 60, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(10000), newGenericThreadFactory("demo-common-thread", false));

    /**
     * 线程工厂
     *
     * @param processName
     *            线程名称前缀
     * @param isDaemon
     *            是否守护线程
     * @return 线程工厂
     */
    public static ThreadFactory newGenericThreadFactory(final String processName, final boolean isDaemon) {
        return new ThreadFactory() {
            private AtomicInteger threadIndex = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, String.format("%s_%d", processName, this.threadIndex.incrementAndGet()));
                thread.setDaemon(isDaemon);
                return thread;
            }
        };
    }
}
