package com.fangyi.kingdee.module_business.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.fangyi.component_library.app.MyBaseLazyFragment;
import com.fangyi.component_library.base.BasePagerAdapter;
import com.fangyi.kingdee.module_business.R;
import com.fangyi.kingdee.module_business.mvp.contract.BusinessContract;
import com.fangyi.kingdee.module_business.mvp.model.BusinessModel;
import com.fangyi.kingdee.module_business.mvp.presenter.BusinessPresenter;
import com.fangyi.kingdee.module_purchase_order.ui.fragment.PurchaseOrderFragment;
import com.fangyi.kingdee.module_sale_order.ui.fragment.SaleOrderFragment;
import com.fangyi.kingdee.module_stocks_order.ui.fragment.StocksOrderFragment;

import java.util.ArrayList;


/**
 * Create By admin On 2017/7/11
 * 功
 */
public class BusinessFragment extends MyBaseLazyFragment<BusinessPresenter, BusinessModel> implements BusinessContract.View {

    private TabLayout mTablayout;
    private ViewPager mViewpager;

    public static BusinessFragment newInstance() {
        BusinessFragment fragment = new BusinessFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_business;
    }

    @Override
    protected void findViewById() {
        mTablayout = rootView.findViewById(R.id.tablayout);
        mViewpager = rootView.findViewById(R.id.viewpager);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();

        fragmentList.add(SaleOrderFragment.newInstance());
        titleList.add("销售");
        fragmentList.add(PurchaseOrderFragment.newInstance());
        titleList.add("采购");
        fragmentList.add(StocksOrderFragment.newInstance());
        titleList.add("库存");

        BasePagerAdapter adapter = new BasePagerAdapter(getChildFragmentManager(), fragmentList, titleList);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(fragmentList.size());

        mTablayout.setupWithViewPager(mViewpager, true);
    }


    @Override
    protected void lazyLoad() {

    }
}
