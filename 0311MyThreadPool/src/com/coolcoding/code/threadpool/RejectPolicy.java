package com.coolcoding.code.threadpool;

public interface RejectPolicy {
    void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor);
}

