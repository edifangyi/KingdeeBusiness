package com.fangyi.component_library.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.fangyi.component_library.func.utils.ZXSharedPrefUtil;


/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/2/27
 * 权    限：
 * 说    明：
 * ================================================
 */
public abstract class BaseActivity extends AppCompatActivity {

    public BaseActivity mActivity;
    public Context mContext;
    public Handler mHandler;
    public ZXSharedPrefUtil mSharedPrefUtil;
    private Thread mThread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        mActivity = this;
        mContext = this;
        mHandler = new Handler();
        mSharedPrefUtil = new ZXSharedPrefUtil(mContext);
        findViewById();
        init(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void findViewById();

    protected abstract void init(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContext = null;
        mHandler = null;
    }


    //处理控制 点击屏幕空白区域隐藏软键盘
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    //处理控制 点击屏幕空白区域隐藏软键盘
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    public void startThread(Runnable run) {
        if (mThread != null) {
            mThread.interrupt();
        }
        mThread = new Thread(run);
        mThread.start();
    }

}
