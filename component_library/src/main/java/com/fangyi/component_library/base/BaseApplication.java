package com.fangyi.component_library.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.fangyi.component_library.BuildConfig;
import com.fangyi.component_library.config.KingdeeAppConfig;
import com.fangyi.component_library.config.KingdeeUrlConfig;
import com.fangyi.component_library.func.utils.Utils;
import com.fangyi.component_library.func.utils.loadsir.EmptyCallback;
import com.fangyi.component_library.func.utils.loadsir.ErrorCallback;
import com.fangyi.component_library.func.utils.loadsir.LoadingCallback;
import com.kingja.loadsir.core.LoadSir;
import com.yanzhenjie.kalle.Kalle;
import com.yanzhenjie.kalle.KalleConfig;
import com.yanzhenjie.kalle.connect.BroadcastNetwork;
import com.yanzhenjie.kalle.connect.http.LoggerInterceptor;
import com.yanzhenjie.kalle.cookie.DBCookieStore;
import com.yanzhenjie.kalle.simple.cache.DiskCacheStore;
import com.yanzhenjie.kalle.urlconnect.URLConnectionFactory;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/5/22
 * ================================================
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);

        if (!BuildConfig.isRelease) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        Kalle.setConfig(KalleConfig.newBuilder()
                .connectFactory(URLConnectionFactory.newBuilder().build())
                .cookieStore(DBCookieStore.newBuilder(this).build())
                .cacheStore(DiskCacheStore.newBuilder(KingdeeAppConfig.get().PATH_APP_CACHE).build())
                .network(new BroadcastNetwork(this))
                .addInterceptor(new LoggerInterceptor("KalleSample", BuildConfig.DEBUG))
                .build());

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();

        initCloudChannel(this);
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    /**
     * 初始化云推送通道
     *
     * @param applicationContext
     */
    private void initCloudChannel(Context applicationContext) {
        PushServiceFactory.init(applicationContext);
        CloudPushService pushService = PushServiceFactory.getCloudPushService();


        pushService.register(applicationContext, new CommonCallback() {
            @Override
            public void onSuccess(String response) {
                String deviceId = pushService.getDeviceId();

                KingdeeUrlConfig.DeviceID = deviceId;

                Log.d("=====", "init cloudchannel success" + deviceId + "======");
            }

            @Override
            public void onFailed(String errorCode, String errorMessage) {
                Log.d("=====", "init cloudchannel failed -- errorcode:" + errorCode + " -- errorMessage:" + errorMessage);
            }

        });
    }
}
