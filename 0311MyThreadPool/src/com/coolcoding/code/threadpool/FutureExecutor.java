package com.coolcoding.code.threadpool;

import java.util.concurrent.Callable;

public interface FutureExecutor extends Executor {
    <T> Future<T> submit(Callable<T> command);
}
