package com.fangyi.kingdee.mvp.model;


import com.fangyi.component_library.base.BaseModel;
import com.fangyi.component_library.func.utils.baserx.ResponseUtil;
import com.fangyi.component_library.func.utils.baserx.ResposeBean;
import com.fangyi.component_library.func.utils.baserx.RxHelper;
import com.fangyi.component_library.func.utils.baserx.RxSchedulers;
import com.fangyi.component_library.func.utils.dbutils.SQLiteDbUtil;
import com.fangyi.component_library.func.utils.dbutils.bean.Users;
import com.fangyi.kingdee.mvp.contract.SplashContract;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class SplashModel extends BaseModel implements SplashContract.Model {


    @Override
    public Observable<Users> doLogin(String username, String password) {
        return createObservable(new Callable<ResposeBean<Users>>() {
            @Override
            public ResposeBean<Users> call() throws Exception {
                List<Users> users = SQLiteDbUtil.getSQLiteDbUtil().query(Users.class);

                ResposeBean respose = ResponseUtil.error("0", "登录失败");

                if (users != null && !users.isEmpty()) {

                    for (Users item : users) {
                        if (item.getUser_sys_id().equals(username) && item.getUser_sys_password().equals(password)) {
                            respose = ResponseUtil.success(item);
                            break;
                        }
                    }
                }

                return respose;
            }
        }).compose(RxSchedulers.io_main())
                .compose(RxHelper.handleResult());
    }
}