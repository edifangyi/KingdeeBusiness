package com.fangyi.component_library.func.utils.baserx;

import com.fangyi.component_library.func.utils.dbutils.ServerException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/8/2
 * 说    明：
 * ================================================
 */
public class RxHelper {
    public static <T> ObservableTransformer<ResposeBean<T>, T> handleResult() {
        return new ObservableTransformer<ResposeBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<ResposeBean<T>> upstream) {
                return upstream.flatMap(new Function<ResposeBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(ResposeBean<T> result) throws Exception {
                        if (result != null && result.success()) {
                            return createData(result.data);
                        } else {
                            return Observable.error(new ServerException(result.code, result.message));
                        }
                    }
                });
            }
        };
    }

    private static <T> ObservableSource<T> createData(T data) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> subscriber) throws Exception {
                try {
                    subscriber.onNext(data);
                    subscriber.onComplete();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
