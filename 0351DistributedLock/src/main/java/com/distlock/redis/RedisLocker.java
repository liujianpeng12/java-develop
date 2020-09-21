package com.distlock.redis;

import com.distlock.Locker;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liujp
 * @create 2020-09-18 9:18
 */
@Component
public class RedisLocker implements Locker {

    @Autowired
    RedissonClient redissonClient;

    @Override
    public void lock(String key, Runnable command) {
        RLock lock = redissonClient.getLock(key);

        try {
            lock.lock();
            command.run();
        } finally {
            lock.unlock();
        }
    }
}
