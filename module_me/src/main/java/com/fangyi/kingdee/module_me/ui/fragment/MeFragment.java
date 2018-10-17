package com.fangyi.kingdee.module_me.ui.fragment;

import android.os.Bundle;

import com.fangyi.component_library.app.MyBaseLazyFragment;
import com.fangyi.kingdee.module_me.R;
import com.fangyi.kingdee.module_me.mvp.contract.MeContract;
import com.fangyi.kingdee.module_me.mvp.model.MeModel;
import com.fangyi.kingdee.module_me.mvp.presenter.MePresenter;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class MeFragment extends MyBaseLazyFragment<MePresenter, MeModel> implements MeContract.View {


    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }


    @Override
    protected void lazyLoad() {

    }
}
