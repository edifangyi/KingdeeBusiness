package com.fangyi.component_library.func.utils.loadsir;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.fangyi.component_library.R;
import com.kingja.loadsir.callback.Callback;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class LoadingCallback extends Callback {

    private Disposable mDisposable;
    private String[] mSymbols = {"   ", ".  ", ".. ", "..."};

    @Override

    protected void onViewCreate(Context context, View view) {
        super.onViewCreate(context, view);
        TextView textView = view.findViewById(R.id.tv_manage);

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Long value) {

                        int index = (int) (value % 4);
                        textView.setText("正在加载中" + mSymbols[index]);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected int onCreateView() {
        return R.layout.layout_loadsir_loading;
    }

    @Override
    public boolean getSuccessVisible() {
        return super.getSuccessVisible();
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        return true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
