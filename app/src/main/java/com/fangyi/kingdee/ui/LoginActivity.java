package com.fangyi.kingdee.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fangyi.component_library.app.MyBaseActivity;
import com.fangyi.kingdee.R;
import com.fangyi.kingdee.mvp.contract.LoginContract;
import com.fangyi.kingdee.mvp.model.LoginModel;
import com.fangyi.kingdee.mvp.presenter.LoginPresenter;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class LoginActivity extends MyBaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    private RelativeLayout mLlLogin;
    private TextView mTvLoginTitle;
    private EditText mEditLoginName;
    private EditText mEditLoginPassword;
    private Button mBtnLoginMain;
    private Button mBtnRegisterMain;

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
    protected void findViewById() {
        mLlLogin = findViewById(R.id.ll_login);
        mTvLoginTitle = findViewById(R.id.tv_login_title);
        mEditLoginName = findViewById(R.id.edit_login_name);
        mEditLoginPassword = findViewById(R.id.edit_login_password);
        mBtnLoginMain = findViewById(R.id.btn_login_main);
        mBtnRegisterMain = findViewById(R.id.btn_register_main);
    }

    @Override
    protected boolean isShowLoadService() {
        return false;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void init(Bundle savedInstanceState) {
        //登录
        RxView.clicks(mBtnLoginMain)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(c -> mPresenter.doLogin(mEditLoginName.getText().toString(), mEditLoginPassword.getText().toString()));

    }


    @Override
    public void onLoginSucceed() {
        MainActivity.startAction(mActivity, true);
    }

    @Override
    public void onLoginError() {
        mEditLoginPassword.setText("");
    }

}
