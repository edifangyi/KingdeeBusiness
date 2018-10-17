package com.fangyi.kingdee.module_sale_order.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fangyi.component_library.app.BusinessItemAdapter;
import com.fangyi.component_library.app.MyBaseLazyFragment;
import com.fangyi.kingdee.module_sale_order.R;
import com.fangyi.kingdee.module_sale_order.mvp.contract.SaleOrderContract;
import com.fangyi.kingdee.module_sale_order.mvp.model.SaleOrderModel;
import com.fangyi.kingdee.module_sale_order.mvp.presenter.SaleOrderPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class SaleOrderFragment extends MyBaseLazyFragment<SaleOrderPresenter, SaleOrderModel> implements SaleOrderContract.View {


    private RecyclerView mRecyclerView;
    private BusinessItemAdapter mAdapter;


    public static SaleOrderFragment newInstance() {
        SaleOrderFragment fragment = new SaleOrderFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId()  {
        return R.layout.fragment_sale_order;
    }

    @Override
    protected void findViewById() {
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        List<String> list = new ArrayList<>();
        list.add("产品入库");
        list.add("生产领料");

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        mAdapter = new BusinessItemAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {


        });
    }


    @Override
    protected void lazyLoad() {

    }


}
