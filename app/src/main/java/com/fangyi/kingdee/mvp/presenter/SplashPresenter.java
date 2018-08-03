package com.fangyi.kingdee.mvp.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.fangyi.component_library.config.KingdeeSharedPref;
import com.fangyi.component_library.config.KingdeeUrlConfig;
import com.fangyi.component_library.func.utils.PhoneUtils;
import com.fangyi.component_library.func.utils.baserx.ResponseObserver;
import com.fangyi.component_library.func.utils.dbutils.ProtocolUtil;
import com.fangyi.component_library.func.utils.dbutils.SQLiteDbUtil;
import com.fangyi.component_library.func.utils.dbutils.bean.DeviceBill;
import com.fangyi.component_library.func.utils.dbutils.bean.DeviceUI;
import com.fangyi.component_library.func.utils.dbutils.bean.DeviceUISet;
import com.fangyi.component_library.func.utils.dbutils.bean.Users;
import com.fangyi.component_library.func.utils.net.NetConnectionUtil;
import com.fangyi.component_library.func.utils.net.WSReturnParam;
import com.fangyi.component_library.func.utils.net.WebService;
import com.fangyi.kingdee.mvp.contract.SplashContract;
import com.socks.library.KLog;

import java.util.List;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class SplashPresenter extends SplashContract.Presenter {


    @Override
    public void doLogin(String name, String password) {


        if (TextUtils.isEmpty(name)) {
            mView.showToast("用户名不能为空");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mView.showToast("密码不能为空");
            return;
        }

        String mServiceAddress = mActivity.mSharedPrefUtil.getString(KingdeeSharedPref.SERVICE_ADDRESS, KingdeeUrlConfig.DEFAULT_SERVICE_ADDRESS);

        if (TextUtils.isEmpty(mServiceAddress)) {
            mView.showToast("服务器地址不能为空");
            return;
        }
        String ip;
        try {
            ip = NetConnectionUtil.getIPAddress(mServiceAddress);
        } catch (Exception e) {
            mView.showToast("服务器IP地址不正确");
            return;
        }

        if (TextUtils.isEmpty(ip)) {
            mView.showToast("服务器IP地址不能为空");
            return;
        }


        mActivity.startThread(() -> {
            if (NetConnectionUtil.pingService(ip)) {
                KLog.e("=====有网络");

                String imei = PhoneUtils.getIMEI();//手机IMEI码
                WebService webService = new WebService(mServiceAddress);
                int code = webService.authorize(name, password, imei);//连接服务器
                if (code > 0) {
                    updateDate(webService, name, password);
                } else {
                    mActivity.mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mView.showToast("用户信息服务验证失败");
                        }
                    });
                    notNetWork();
                }
            } else {
                KLog.e("=====无网络");

            }
        });
    }

    private void notNetWork() {

    }

    @SuppressLint("CheckResult")
    private void updateDate(WebService webService, String name, String password) {
        WSReturnParam wsParam = new WSReturnParam();

        Integer currentPg = 0; // 当前执行页数


        wsParam.result = 0; // 执行结果
        wsParam.totalPg = 0;// 总共还需执行页数
        String protoUsersStr = webService.getData(wsParam, currentPg, "Users", name);

        wsParam.result = 0;
        wsParam.totalPg = 0;
        String protoDeviceUIStr = webService.getData(wsParam, currentPg, "DeviceUI", name);

        wsParam.result = 0;
        wsParam.totalPg = 0;
        String protoDeviceBillSetStr = webService.getData(wsParam, currentPg, "DeviceBillSet", name);

        wsParam.result = 0;
        wsParam.totalPg = 0;
        String protoDeviceBillStr = webService.getData(wsParam, currentPg, "DeviceBill", name);


        List<String> usersSql = ProtocolUtil.getInsertSQL("Users", protoUsersStr);
        List<String> deviceuiSql = ProtocolUtil.getInsertSQL("DeviceUI", protoDeviceUIStr);
        List<String> devicebillsetSql = ProtocolUtil.getInsertSQL("DeviceBillSet", protoDeviceBillSetStr);
        List<String> devicebillSql = ProtocolUtil.getInsertSQL("DeviceBill", protoDeviceBillStr);


        mModel.doLogin(name, password)
                .subscribeWith(new ResponseObserver<Users>(mView) {
                    @Override
                    protected void _onNext(Users users) {

                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(usersSql);
                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(deviceuiSql);
                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(devicebillsetSql);
                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(devicebillSql);
                    }

                    @Override
                    protected void _onError(String message) {

//                        SQLiteDbUtil.getSQLiteDbUtil().deleteDevice("users", name);
//                        SQLiteDbUtil.getSQLiteDbUtil().deleteDevice("devicebill", name);
//                        SQLiteDbUtil.getSQLiteDbUtil().deleteDevice("deviceui", name);
//                        SQLiteDbUtil.getSQLiteDbUtil().deleteDevice("deviceuiset", name);

                        SQLiteDbUtil.getSQLiteDbUtil().delete(Users.class, "user_sys_id=" + name);
                        SQLiteDbUtil.getSQLiteDbUtil().delete(DeviceBill.class, "user_sys_id=" + name);
                        SQLiteDbUtil.getSQLiteDbUtil().delete(DeviceUI.class, "user_sys_id=" + name);
                        SQLiteDbUtil.getSQLiteDbUtil().delete(DeviceUISet.class, "user_sys_id=" + name);


                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(usersSql);
                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(deviceuiSql);
                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(devicebillsetSql);
                        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(devicebillSql);

                    }
                });
    }


}