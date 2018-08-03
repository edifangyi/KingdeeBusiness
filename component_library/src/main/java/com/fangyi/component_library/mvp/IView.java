package com.fangyi.component_library.mvp;

import android.view.View;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/1/25
 * ================================================
 */
public interface IView {

    void showLoading();

    void showLoading(String message);

    void showLoading(String message, int progress);

    void dismissLoading();

    void showToast(String message);

    void showErrorToast(String message);

}
