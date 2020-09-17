package com.distlock;

/**
 * @author liujp
 * @create 2020-09-17 10:22
 */
public interface Locker {
    void lock(String key, Runnable command);
}
