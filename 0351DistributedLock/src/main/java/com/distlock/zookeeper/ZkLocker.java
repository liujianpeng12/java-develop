package com.distlock.zookeeper;

import com.distlock.Locker;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liujp
 * @create 2020-09-17 11:40
 */
@Slf4j
@Component
public class ZkLocker implements Locker {

    @Override
    public void lock(String key, Runnable command) {
        ZkLockerWatcher watcher = ZkLockerWatcher.conn(key);
        try {
            if(watcher.getLock()) {
                command.run();
            }
        } finally {
            watcher.releaseLock();
        }
    }
}
