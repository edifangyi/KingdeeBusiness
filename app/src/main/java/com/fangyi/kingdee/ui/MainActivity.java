package com.fangyi.kingdee.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fangyi.component_library.app.MyBaseActivity;
import com.fangyi.component_library.config.KingdeeUrlConfig;
import com.fangyi.component_library.func.utils.update.UpdateUtils;
import com.fangyi.kingdee.R;
import com.fangyi.kingdee.mvp.contract.MainContract;
import com.fangyi.kingdee.mvp.model.MainModel;
import com.fangyi.kingdee.mvp.presenter.MainPresenter;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class MainActivity extends MyBaseActivity<MainPresenter, MainModel> implements MainContract.View {

    public static void startAction(Activity activity, boolean isFinish) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        if (isFinish) activity.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected boolean isShowLoadService() {
        return false;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        UpdateUtils.getConfig()
                .setUrl(KingdeeUrlConfig.upData)
                .setOnUpdateListener(new UpdateUtils.OnUpdateListener() {
                    @Override
                    public void onNoUpdate() {


                    }

                    @Override
                    public void onLater() {

                    }

                    @Override
                    public void onIgnore(String newVersion) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                })
                .check(mContext);
    }


}
