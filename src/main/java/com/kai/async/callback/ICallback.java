package com.kai.async.callback;

import com.kai.async.worker.WorkResult;

/**
 * 每个执行单元执行完毕之后，会调用该接口
 * 需要监听结果的，实现该接口
 */
@FunctionalInterface
public interface ICallback<T, V> {

    /**
     * 任务开始的监听
     */
    default void begin() {

    }

    /**
     * 异步的结果
     */
    void result(boolean success, T param, WorkResult<V> workerResult);
}