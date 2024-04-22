package com.kai.async.callback;

import com.kai.async.worker.WorkResult;

public class DefaultCallback<T, V> implements ICallback<T, V>{

    @Override
    public void begin() {

    }

    @Override
    public void result(boolean success, T param, WorkResult<V> workerResult) {

    }
}