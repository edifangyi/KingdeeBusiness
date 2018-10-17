package com.fangyi.kingdee.module_stocks_order.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fangyi.component_library.app.BusinessItemAdapter;
import com.fangyi.component_library.app.MyBaseLazyFragment;
import com.fangyi.kingdee.module_stocks_order.R;
import com.fangyi.kingdee.module_stocks_order.mvp.contract.StocksOrderContract;
import com.fangyi.kingdee.module_stocks_order.mvp.model.StocksOrderModel;
import com.fangyi.kingdee.module_stocks_order.mvp.presenter.StocksOrderPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class StocksOrderFragment extends MyBaseLazyFragment<StocksOrderPresenter, StocksOrderModel> implements StocksOrderContract.View {


    private RecyclerView mRecyclerView;
    private BusinessItemAdapter mAdapter;


    public static StocksOrderFragment newInstance() {
        StocksOrderFragment fragment = new StocksOrderFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_stocks_order;
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
