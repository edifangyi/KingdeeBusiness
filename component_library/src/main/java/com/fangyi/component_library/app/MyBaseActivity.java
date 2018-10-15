package com.fangyi.component_library.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fangyi.component_library.base.BaseModel;
import com.fangyi.component_library.base.BasePresenter;
import com.fangyi.component_library.base.MvpBaseActivity;
import com.fangyi.component_library.func.utils.loadsir.LoadingCallback;
import com.fangyi.component_library.func.widget.dialog.QMUITipDialog;
import com.fangyi.component_library.mvp.IView;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2017/12/11
 * 说    明：
 * ================================================
 */
public abstract class MyBaseActivity<P extends BasePresenter, M extends BaseModel> extends MvpBaseActivity<P, M> implements IView {
    public LoadService mLoadService;
    private QMUITipDialog mTipDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadService = LoadSir.getDefault().register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {

            }
        });

        if (isShowLoadService())
            mLoadService.showCallback(LoadingCallback.class);
        else
            mLoadService.showSuccess();
    }

    protected abstract boolean isShowLoadService();

    @Override
    public void showLoading() {
        showLoading("正在加载中");
    }

    @Override
    public void showLoading(String message) {
        if (mTipDialog != null) {
            mTipDialog.dismiss();
        }

        mTipDialog = new QMUITipDialog.Builder(mActivity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord(message)
                .create();

        mTipDialog.show();
    }

    @Override
    public void showLoading(String message, int progress) {

    }

    @Override
    public void dismissLoading() {
        if (mTipDialog != null && mTipDialog.isShowing()) {
            mTipDialog.dismiss();
        }
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorToast(String message) {
        if (mTipDialog != null) {
            mTipDialog.dismiss();
        }
        mTipDialog = new QMUITipDialog.Builder(mActivity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                .setTipWord(message)
                .setDuration(2000)
                .create();

        mTipDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoading();
    }
}