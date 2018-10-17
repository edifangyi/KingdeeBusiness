package com.fangyi.kingdee.module_purchase_order.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fangyi.component_library.app.BusinessItemAdapter;
import com.fangyi.component_library.app.MyBaseLazyFragment;
import com.fangyi.kingdee.module_purchase_order.R;
import com.fangyi.kingdee.module_purchase_order.mvp.contract.PurchaseOrderContract;
import com.fangyi.kingdee.module_purchase_order.mvp.model.PurchaseOrderModel;
import com.fangyi.kingdee.module_purchase_order.mvp.presenter.PurchaseOrderPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class PurchaseOrderFragment extends MyBaseLazyFragment<PurchaseOrderPresenter, PurchaseOrderModel> implements PurchaseOrderContract.View {


    private RecyclerView mRecyclerView;
    private BusinessItemAdapter mAdapter;


    public static PurchaseOrderFragment newInstance() {
        PurchaseOrderFragment fragment = new PurchaseOrderFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_purchase_order;
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
