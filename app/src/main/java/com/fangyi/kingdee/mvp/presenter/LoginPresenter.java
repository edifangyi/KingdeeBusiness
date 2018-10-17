package com.fangyi.kingdee.mvp.presenter;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.fangyi.component_library.config.KingdeeSharedPref;
import com.fangyi.component_library.config.KingdeeUrlConfig;
import com.fangyi.component_library.func.manage.UserManage;
import com.fangyi.component_library.func.utils.PhoneUtils;
import com.fangyi.component_library.func.utils.baserx.ResponseObserver;
import com.fangyi.component_library.func.utils.baserx.RxHelper;
import com.fangyi.component_library.func.utils.baserx.RxSchedulers;
import com.fangyi.component_library.func.utils.dbutils.ProtocolUtil;
import com.fangyi.component_library.func.utils.dbutils.SQLiteDbUtil;
import com.fangyi.component_library.func.utils.dbutils.bean.DeviceBill;
import com.fangyi.component_library.func.utils.dbutils.bean.DeviceUI;
import com.fangyi.component_library.func.utils.dbutils.bean.Users;
import com.fangyi.component_library.func.utils.net.NetConnectionUtil;
import com.fangyi.component_library.func.utils.net.WSReturnParam;
import com.fangyi.component_library.func.utils.net.WebService;
import com.fangyi.kingdee.mvp.contract.LoginContract;

import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class LoginPresenter extends LoginContract.Presenter {

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

        mActivity.startThread(() -> {
            if (NetConnectionUtil.pingService(ip)) {
                WebService webService = new WebService(mServiceAddress);
                int code = webService.authorize(name, password, PhoneUtils.getIMEI());//连接服务器
                if (code > 0) {
                    updateDate(webService, name, password);
                } else {
                    notNetWork(name, password);
                }
            } else {
                notNetWork(name, password);
            }
        });
    }

    @SuppressLint("CheckResult")
    private void notNetWork(String name, String password) {

//        mModel.doLogin(name, password)
//                .subscribeWith(new ResponseObserver<Users>(mView) {
//                    @Override
//                    protected void _onNext(Users users) {
//                        UserManage.getInstance().setUser(mActivity, users);
//                        mView.onLoginSucceed();
//                    }
//
//                    @Override
//                    protected void _onError(String message) {
//                        mView.showErrorToast(message);
//                        mView.onLoginError();
//                    }
//                });

        mModel.doLogin(name, password)
                .flatMap(new Function<Users, ObservableSource<DeviceUI>>() {
                    @Override
                    public ObservableSource<DeviceUI> apply(Users users) throws Exception {
                        //处理登录数据
                        UserManage.getInstance().setUser(mActivity, users);
                        return mModel.getDeviceUI(users.getUser_sys_id());
                    }
                })
                .flatMap(new Function<DeviceUI, ObservableSource<DeviceBill>>() {
                    @Override
                    public ObservableSource<DeviceBill> apply(DeviceUI deviceUI) throws Exception {

                        UserManage.getInstance().setDeviceUI(deviceUI);

                        return mModel.getDeviceBill(UserManage.getInstance().getUsers().getUser_sys_id());
                    }
                })
                .subscribeWith(new ResponseObserver<DeviceBill>() {
                    @Override
                    protected void _onNext(DeviceBill deviceBill) {
                        UserManage.getInstance().setDeviceBill(deviceBill);
                        mView.onLoginSucceed();
                    }

                    @Override
                    protected void _onError(String message) {
                        mView.showErrorToast(message);
                        mView.onLoginError();
                    }
                });

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

        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(ProtocolUtil.getInsertSQL("Users", protoUsersStr));
        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(ProtocolUtil.getInsertSQL("DeviceUI", protoDeviceUIStr));
        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData(ProtocolUtil.getInsertSQL("DeviceBillSet", protoDeviceBillSetStr));
        SQLiteDbUtil.getSQLiteDbUtil().insertDownloadData( ProtocolUtil.getInsertSQL("DeviceBill", protoDeviceBillStr));

        notNetWork(name, password);
    }

}