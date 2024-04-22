package com.kai.async.callback;

import com.kai.async.wrapper.WorkerWrapper;

import java.util.Map;

public interface IWorker<T, V> {

    /**
     * 任务的执行，执行耗时任务，如rpc调用，io等
     * @param object    object
     * @return          执行结果
     */
    V action(T object, Map<String, WorkerWrapper> forParamUseWrappers);

    /**
     * 超时、异常时，返回的默认值
     *
     * @return 默认值
     */
    default V defaultValue() {
        return null;
    }

}