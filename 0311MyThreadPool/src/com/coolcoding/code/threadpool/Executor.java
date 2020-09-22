package com.coolcoding.code.threadpool;

public interface Executor {
    void execute(Runnable command);
}
