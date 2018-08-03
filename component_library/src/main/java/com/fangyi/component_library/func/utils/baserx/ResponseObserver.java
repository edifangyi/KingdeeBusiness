package com.fangyi.component_library.func.utils.baserx;

import com.fangyi.component_library.mvp.IView;

import io.reactivex.observers.DefaultObserver;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/8/1
 * 说    明：
 * ================================================
 */
public abstract class ResponseObserver<T> extends DefaultObserver<T> {
    private IView iView;
    private String msg;

    public ResponseObserver() {
    }

    public ResponseObserver(IView iView) {
        this(iView, "正在加载中...");
    }

    public ResponseObserver(IView iView, String msg) {
        this.msg = msg;
        this.iView = iView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (iView != null) {
            try {
                if (msg != null) {
                    iView.showLoading(msg);
                } else {
                    iView.showLoading("正在加载中...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onComplete() {
        if (iView != null) {
            iView.dismissLoading();
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String message = e.getMessage();
        _onError(message);
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);


}
