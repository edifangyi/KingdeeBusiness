package com.fangyi.component_library.app;

import android.view.View;
import android.widget.Toast;

import com.fangyi.component_library.base.BaseModel;
import com.fangyi.component_library.base.BasePresenter;
import com.fangyi.component_library.base.MvpBaseActivity;
import com.fangyi.component_library.mvp.IView;
import com.fangyi.component_library.func.widget.dialog.QMUITipDialog;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2017/12/11
 * 说    明：
 * ================================================
 */
public abstract class MyBaseActivity<P extends BasePresenter, M extends BaseModel> extends MvpBaseActivity<P, M> implements IView {

    private QMUITipDialog tipDialog;

    @Override
    public void showLoading() {
        showLoading("正在加载中");
    }

    @Override
    public void showLoading(String message) {
        tipDialog = new QMUITipDialog.Builder(mActivity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord(message)
                .create();

        tipDialog.show();
    }

    @Override
    public void showLoading(String message, int progress) {

    }

    @Override
    public void dismissLoading() {
        if (tipDialog != null || tipDialog.isShowing()) {
            tipDialog.dismiss();
        }
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorToast(String message) {
        tipDialog = new QMUITipDialog.Builder(mActivity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                .setTipWord(message)
                .setDuration(2000)
                .create();

        tipDialog.show();
    }

    @Override
    protected void onDestroy() {
        dismissLoading();
        super.onDestroy();
    }
}