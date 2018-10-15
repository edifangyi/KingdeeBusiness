package com.fangyi.kingdee.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.fangyi.component_library.app.MyBaseActivity;
import com.fangyi.component_library.config.KingdeeSharedPref;
import com.fangyi.component_library.func.utils.dbutils.SQLiteDbUtil;
import com.fangyi.component_library.func.utils.permission.PermissionUtils;
import com.fangyi.kingdee.R;
import com.fangyi.kingdee.mvp.contract.LoginContract;
import com.fangyi.kingdee.mvp.model.LoginModel;
import com.fangyi.kingdee.mvp.presenter.LoginPresenter;
import com.jakewharton.rxbinding2.view.RxView;
import com.yanzhenjie.permission.Permission;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class SplashActivity extends MyBaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    private TextView mTvGo;

    //倒计时操作
    private final int count = 5;
    //倒计时
    private Disposable mDisposable;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void findViewById() {
        mTvGo = findViewById(R.id.tv_go);
    }

    @Override
    protected boolean isShowLoadService() {
        return false;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void init(Bundle savedInstanceState) {
        mTvGo.setVisibility(View.GONE);

        PermissionUtils.newBuilder()
                .requestPermission(
                        Permission.CALL_PHONE,
                        Permission.ACCESS_COARSE_LOCATION,
                        Permission.ACCESS_FINE_LOCATION,
                        Permission.READ_PHONE_STATE,
                        Permission.WRITE_EXTERNAL_STORAGE,
                        Permission.READ_EXTERNAL_STORAGE)
                .setOnGrantedListener(() -> {
                    SQLiteDbUtil.getSQLiteDbUtil().openDataBase(mContext);


                    Observable.interval(0, 1, TimeUnit.SECONDS)
                            .take(count + 1)
                            .map(aLong -> count - aLong)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<Long>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                    mDisposable = d;
                                }

                                @Override
                                public void onNext(Long value) {
                                    mTvGo.setText(" 立即进去 " + value + " ");
                                    mTvGo.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                }

                                @Override
                                public void onComplete() {
                                    doLogin();
                                }
                            });

                    RxView.clicks(mTvGo)
                            .throttleFirst(1, TimeUnit.SECONDS)
                            .subscribe(c -> {
                                if (mDisposable != null && !mDisposable.isDisposed()) {
                                    mDisposable.dispose();
                                }
                                doLogin();
                            });

                }).builder(mContext);


    }

    private void doLogin() {
        String name = mSharedPrefUtil.getString(KingdeeSharedPref.USER_NAME);
        String password = mSharedPrefUtil.getString(KingdeeSharedPref.USER_PASSWORD);

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            onLoginError();
        } else {
            mPresenter.doLogin(name, password);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    @Override
    public void onLoginSucceed() {
        MainActivity.startAction(mActivity, true);
    }

    @Override
    public void onLoginError() {
        LoginActivity.startAction(mActivity, true);
    }

}
