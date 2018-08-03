package com.fangyi.component_library.base;

import android.os.Bundle;

import com.fangyi.component_library.mvp.IView;
import com.fangyi.component_library.func.utils.ClassUtil;
import com.fangyi.component_library.func.utils.net.NetworkUtils;


/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/1/23
 * 说    明：MVP、懒加载的Fragment
 * ================================================
 */
public abstract class MvpLazyFragment<P extends BasePresenter, M extends BaseModel> extends BaseLazyFragment implements IView {

    public P mPresenter;
    public M mModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPresenter = ClassUtil.getT(this, 0);
        mModel = ClassUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.attachActivity(mActivity);
            mPresenter.attachView(this);
            mPresenter.attachModel(mModel);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            //断开View引用
            mPresenter.detachView();
        }
    }

}