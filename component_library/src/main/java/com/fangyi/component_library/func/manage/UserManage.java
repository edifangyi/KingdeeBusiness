package com.fangyi.component_library.func.manage;

import android.content.Context;

import com.fangyi.component_library.base.BaseActivity;
import com.fangyi.component_library.config.KingdeeSharedPref;
import com.fangyi.component_library.func.utils.ZXSharedPrefUtil;
import com.fangyi.component_library.func.utils.dbutils.bean.Users;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/8/2
 * 说    明：
 * ================================================
 */
public class UserManage {
    private static UserManage manager;

    private Users mUsers;

    public static UserManage getInstance() {
        if (manager == null) {
            manager = new UserManage();
        }
        return manager;
    }

    public void setUser(Context context, Users users) {
        mUsers = users;

        ZXSharedPrefUtil mSharedPrefUtil = new ZXSharedPrefUtil(context);
        mSharedPrefUtil.putString(KingdeeSharedPref.USER_NAME, users.getUser_sys_id());
        mSharedPrefUtil.putString(KingdeeSharedPref.USER_PASSWORD, users.getUser_sys_password());
    }

    public Users getUsers() {
        return mUsers;
    }
}
