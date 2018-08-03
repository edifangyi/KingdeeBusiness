package com.fangyi.kingdee.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fangyi.component_library.app.MyBaseActivity;
import com.fangyi.component_library.config.KingdeeSharedPref;
import com.fangyi.component_library.func.utils.dbutils.SQLiteDbUtil;
import com.fangyi.component_library.func.utils.permission.PermissionUtils;
import com.fangyi.kingdee.R;
import com.fangyi.kingdee.mvp.contract.SplashContract;
import com.fangyi.kingdee.mvp.model.SplashModel;
import com.fangyi.kingdee.mvp.presenter.SplashPresenter;
import com.yanzhenjie.permission.Permission;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class SplashActivity extends MyBaseActivity<SplashPresenter, SplashModel> implements SplashContract.View {



    public static void startAction(Activity activity, boolean isFinish) {
        Intent intent = new Intent(activity, SplashActivity.class);
        activity.startActivity(intent);
        if (isFinish) activity.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void init(Bundle savedInstanceState) {


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

                    String name = mSharedPrefUtil.getString(KingdeeSharedPref.USER_NAME);
                    String password = mSharedPrefUtil.getString(KingdeeSharedPref.USER_PASSWORD);

                    mPresenter.doLogin(name, password);

//                        UpdateUtils.getConfig()
//                                .setUrl(UrlConfig.upData)
//                                .setOnUpdateListener(new UpdateUtils.OnUpdateListener() {
//                                    @Override
//                                    public void onNoUpdate() {
//
//                                        LoginActivity.startAction(mActivity,true);
//
//                                    }
//
//                                    @Override
//                                    public void onLater() {
//
//                                    }
//
//                                    @Override
//                                    public void onIgnore(String newVersion) {
//
//                                    }
//
//                                    @Override
//                                    public void onError(String message) {
//
//                                    }
//                                })
//                                .check(mContext);
                }).builder(mContext);


    }


    @Override
    public void onLoginSucceed() {

    }

    @Override
    public void onLoginError() {

    }
}
