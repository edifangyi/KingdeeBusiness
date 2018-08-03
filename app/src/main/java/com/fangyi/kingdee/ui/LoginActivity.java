package com.fangyi.kingdee.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fangyi.component_library.app.MyBaseActivity;
import com.fangyi.kingdee.R;
import com.fangyi.kingdee.mvp.contract.LoginContract;
import com.fangyi.kingdee.mvp.model.LoginModel;
import com.fangyi.kingdee.mvp.presenter.LoginPresenter;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class LoginActivity extends MyBaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    public static void startAction(Activity activity, boolean isFinish) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        if (isFinish) activity.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }


}
