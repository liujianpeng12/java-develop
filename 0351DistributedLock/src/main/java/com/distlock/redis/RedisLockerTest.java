package com.distlock.redis;

import com.distlock.Application;
import com.distlock.Locker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liujp
 * @create 2020-09-18 9:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisLockerTest {

    @Autowired
    Locker locker;

    int num = 0;

    @Test
    public void testRedisLocker() {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                locker.lock("lock", ()->{
                    //可重入锁
                    //locker.lock("lock", ()->{
                        num++;
                        System.out.println(num);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    //});
                });
            }).start();
        }
    }
}
