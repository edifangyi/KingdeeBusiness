package com.fangyi.component_library.base;


import com.fangyi.component_library.mvp.IModel;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/1/24
 * 说    明：
 * ================================================
 */
public class BaseModel implements IModel {

    public static <T> Observable<T> createObservable(final Callable<T> callable) {
        return Observable.fromCallable(callable);
    }
}
