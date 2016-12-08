package com.baymax724.study.rxjava.hystrix.plugins;

import com.netflix.hystrix.HystrixInvokable;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;

/**
 * Created by sunao on 2016/12/8.
 */
public class HystrixCommandHook extends HystrixCommandExecutionHook {

    /**
     * Invoked before HystrixInvokable begins executing.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onStart(HystrixInvokable<T> commandInstance) {
        super.onStart(commandInstance);
    }

    /**
     * Invoked when HystrixInvokable emits a value.
     *
     * @param commandInstance
     * @param value
     * @param <T>
     * @return
     */
    @Override
    public <T> T onEmit(HystrixInvokable<T> commandInstance, T value) {
        return super.onEmit(commandInstance, value);
    }

    /**
     * Invoked when HystrixInvokable fails with an Exception.
     * Why to add runtime monitor in hook onError and onSuccess:
     * See : https://github.com/Netflix/Hystrix/issues/1386
     *
     * @param commandInstance
     * @param failureType
     * @param e
     * @param <T>
     * @return
     */
    @Override
    public <T> Exception onError(HystrixInvokable<T> commandInstance, HystrixRuntimeException.FailureType failureType, Exception e) {
        return super.onError(commandInstance, failureType, e);
    }

    /**
     * Invoked when HystrixInvokable finishes a successful execution.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onSuccess(HystrixInvokable<T> commandInstance) {
        super.onSuccess(commandInstance);
    }

    /**
     * Invoked at start of thread execution when HystrixCommand is executed
     * using HystrixCommandProperties.ExecutionIsolationStrategy.THREAD.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onThreadStart(HystrixInvokable<T> commandInstance) {
        super.onThreadStart(commandInstance);
    }

    /**
     * Invoked at completion of thread execution when HystrixCommand is executed
     * using HystrixCommandProperties.ExecutionIsolationStrategy.THREAD.
     * This will get invoked whenever the Hystrix thread is done executing,
     * regardless of whether the thread finished naturally, or was unsubscribed externally
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onThreadComplete(HystrixInvokable<T> commandInstance) {
        super.onThreadComplete(commandInstance);
    }

    /**
     * Invoked when the user-defined execution method in HystrixInvokable starts.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
        super.onExecutionStart(commandInstance);
    }

    /**
     * Invoked when the user-defined execution method in HystrixInvokable emits a value.
     *
     * @param commandInstance
     * @param value
     * @param <T>
     * @return
     */
    @Override
    public <T> T onExecutionEmit(HystrixInvokable<T> commandInstance, T value) {
        return super.onExecutionEmit(commandInstance, value);
    }

    /**
     * Invoked when the user-defined execution method in HystrixInvokable fails with an Exception.
     *
     * @param commandInstance
     * @param e
     * @param <T>
     * @return
     */
    @Override
    public <T> Exception onExecutionError(HystrixInvokable<T> commandInstance, Exception e) {
        return super.onExecutionError(commandInstance, e);
    }

    /**
     * Invoked when the user-defined execution method in HystrixInvokable completes successfully.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onExecutionSuccess(HystrixInvokable<T> commandInstance) {
        super.onExecutionSuccess(commandInstance);
    }

    /**
     * Invoked when the fallback method in HystrixInvokable starts.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onFallbackStart(HystrixInvokable<T> commandInstance) {
        super.onFallbackStart(commandInstance);
    }

    /**
     * Invoked when the fallback method in HystrixInvokable emits a value.
     *
     * @param commandInstance
     * @param value
     * @param <T>
     * @return
     */
    @Override
    public <T> T onFallbackEmit(HystrixInvokable<T> commandInstance, T value) {
        return super.onFallbackEmit(commandInstance, value);
    }

    /**
     * Invoked when the fallback method in HystrixInvokable fails with an Exception.
     *
     * @param commandInstance
     * @param e
     * @param <T>
     * @return
     */
    @Override
    public <T> Exception onFallbackError(HystrixInvokable<T> commandInstance, Exception e) {
        return super.onFallbackError(commandInstance, e);
    }

    /**
     * Invoked when the user-defined execution method in HystrixInvokable completes successfully.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onFallbackSuccess(HystrixInvokable<T> commandInstance) {
        super.onFallbackSuccess(commandInstance);
    }

    /**
     * Invoked when the command response is found in the HystrixRequestCache.
     *
     * @param commandInstance
     * @param <T>
     */
    @Override
    public <T> void onCacheHit(HystrixInvokable<T> commandInstance) {
        super.onCacheHit(commandInstance);
    }
}
