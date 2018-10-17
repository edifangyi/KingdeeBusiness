package com.fangyi.kingdee.module_map.ui.fragment;

import android.os.Bundle;

import com.fangyi.component_library.app.MyBaseLazyFragment;
import com.fangyi.kingdee.module_map.R;
import com.fangyi.kingdee.module_map.mvp.contract.MapContract;
import com.fangyi.kingdee.module_map.mvp.model.MapModel;
import com.fangyi.kingdee.module_map.mvp.presenter.MapPresenter;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class MapFragment extends MyBaseLazyFragment<MapPresenter, MapModel> implements MapContract.View {


    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_map;
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
