package com.fangyi.kingdee.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;

import com.fangyi.component_library.app.MyBaseActivity;
import com.fangyi.component_library.base.BasePagerAdapter;
import com.fangyi.component_library.config.KingdeeUrlConfig;
import com.fangyi.component_library.func.utils.update.UpdateUtils;
import com.fangyi.component_library.func.widget.NoScrollViewPager;
import com.fangyi.kingdee.R;
import com.fangyi.kingdee.module_business.ui.fragment.BusinessFragment;
import com.fangyi.kingdee.module_map.ui.fragment.MapFragment;
import com.fangyi.kingdee.module_me.ui.fragment.MeFragment;
import com.fangyi.kingdee.mvp.contract.MainContract;
import com.fangyi.kingdee.mvp.model.MainModel;
import com.fangyi.kingdee.mvp.presenter.MainPresenter;

import java.util.ArrayList;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class MainActivity extends MyBaseActivity<MainPresenter, MainModel> implements MainContract.View {

    private NoScrollViewPager mNoPagerView;
    private PageNavigationView mPageNavigationView;

    private NavigationController navigationController;

    public static void startAction(Activity activity, boolean isFinish) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        if (isFinish) activity.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViewById() {
        mNoPagerView = findViewById(R.id.no_pager_view);
        mPageNavigationView = findViewById(R.id.page_navigation_view);
    }

    @Override
    protected boolean isShowLoadService() {
        return false;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        UpdateUtils.getConfig()
                .setUrl(KingdeeUrlConfig.upData)
                .setOnUpdateListener(new UpdateUtils.OnUpdateListener() {
                    @Override
                    public void onNoUpdate() {


                    }

                    @Override
                    public void onLater() {

                    }

                    @Override
                    public void onIgnore(String newVersion) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                })
                .check(mContext);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(BusinessFragment.newInstance());
        fragmentArrayList.add(MapFragment.newInstance());
        fragmentArrayList.add(MeFragment.newInstance());

        BasePagerAdapter adapter = new BasePagerAdapter(getSupportFragmentManager(), fragmentArrayList);
        mNoPagerView.setOffscreenPageLimit(fragmentArrayList.size());
        mNoPagerView.setAdapter(adapter);


        navigationController = mPageNavigationView.material()
                .addItem(R.drawable.app_main_ic_business, R.drawable.app_main_ic_business_checked, "首页")
                .addItem(R.drawable.app_main_ic_map, R.drawable.app_main_ic_map_checked, "地图")
                .addItem(R.drawable.app_main_ic_me, R.drawable.app_main_ic_me_checked, "我的")
                .build();

        navigationController.setupWithViewPager(mNoPagerView);
    }

    private long triggerAtTimefirst = 0;

    @Override
    public void onBackPressed() {
        long triggerAtTimeSecond = triggerAtTimefirst;
        triggerAtTimefirst = SystemClock.elapsedRealtime();

        if (triggerAtTimefirst - triggerAtTimeSecond <= 2000) {
            super.onBackPressed();
            System.exit(0);
        } else {

            showToast("请再点击一次, 确认退出...");
        }
    }
}
