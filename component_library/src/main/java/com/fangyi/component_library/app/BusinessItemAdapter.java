package com.fangyi.component_library.app;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangyi.component_library.R;

import java.util.List;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/10/15
 * 说    明：
 * ================================================
 */
public class BusinessItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public BusinessItemAdapter(@Nullable List<String> data) {
        super(R.layout.layout_business_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item);
    }
}