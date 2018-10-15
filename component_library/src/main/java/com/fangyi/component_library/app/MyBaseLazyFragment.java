package com.fangyi.component_library.app;

import android.widget.Toast;

import com.fangyi.component_library.base.BaseModel;
import com.fangyi.component_library.base.BasePresenter;
import com.fangyi.component_library.base.MvpLazyFragment;
import com.fangyi.component_library.func.widget.dialog.QMUITipDialog;
import com.fangyi.component_library.mvp.IView;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2017/12/11
 * 说    明：
 * ================================================
 */
public abstract class MyBaseLazyFragment<P extends BasePresenter, M extends BaseModel> extends MvpLazyFragment<P, M> implements IView {
    private QMUITipDialog tipDialog;

    @Override
    public void showLoading() {
        showLoading("正在加载中");
    }


    @Override
    public void showLoading(String message) {
        if (tipDialog != null) {
            tipDialog.dismiss();
        }

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
        if (tipDialog != null && tipDialog.isShowing()) {
            tipDialog.dismiss();
        }
    }


    @Override
    public void showErrorToast(String message) {
        if (tipDialog != null) {
            tipDialog.dismiss();
        }
        tipDialog = new QMUITipDialog.Builder(mActivity)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                .setTipWord(message)
                .setDuration(2000)
                .create();

        tipDialog.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissLoading();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }
}