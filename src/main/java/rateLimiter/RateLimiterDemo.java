package rateLimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

public class RateLimiterDemo {
    static RateLimiter limiter = RateLimiter.create(2);      // 限流  限制 临界代码 一次只能有两个线程操作  谷歌提供的 对java  jdk 扩展的包中的类  GUAVA

    public static class Task implements Runnable{

        @Override
        public void run (){
            System.out.println(System.currentTimeMillis());
        }

    }
@Test
    public void testDemo ()throws Exception{
        for(int i = 0 ;i< 50; i++){
            limiter.acquire();
            new Thread(new Task()).start();
        }
    }

}
