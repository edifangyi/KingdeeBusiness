package com.fangyi.kingdee.mvp.model;


import com.fangyi.component_library.base.BaseModel;
import com.fangyi.component_library.func.utils.baserx.ResponseUtil;
import com.fangyi.component_library.func.utils.baserx.ResposeBean;
import com.fangyi.component_library.func.utils.baserx.RxHelper;
import com.fangyi.component_library.func.utils.baserx.RxSchedulers;
import com.fangyi.component_library.func.utils.dbutils.SQLiteDbUtil;
import com.fangyi.component_library.func.utils.dbutils.bean.Users;
import com.fangyi.kingdee.mvp.contract.LoginContract;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class LoginModel extends BaseModel implements LoginContract.Model {

    @Override
    public Observable<Users> doLogin(String username, String password) {
        return createObservable(new Callable<ResposeBean<Users>>() {
            @Override
            public ResposeBean<Users> call() throws Exception {
                List<Users> usersList = SQLiteDbUtil.getSQLiteDbUtil().query(Users.class, "user_sys_id = ? and user_sys_password = ?", new String[]{username, password});
                ResposeBean respose = null;
                if (usersList == null || usersList.isEmpty()) {
                    respose = ResponseUtil.error(ResponseUtil.CODE_10001);
                } else {
                    if (usersList.get(0).getUser_sys_id().equals(username) && usersList.get(0).getUser_sys_password().equals(password)) {
                        respose = ResponseUtil.success(usersList.get(0));
                    }
                }
                return respose;
            }
        }).compose(RxSchedulers.io_main())
                .compose(RxHelper.handleResult());
    }

}