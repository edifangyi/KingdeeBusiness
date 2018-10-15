package com.fangyi.component_library.func.utils.baserx;


import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

public class ResponseUtil {

    public static final String CODE_10000 = "错误";

    public static final String CODE_10001 = "此帐号未登录过本设备 \n请连接服务器进行验证";

    public static final String CODE_200 = "成功";
    private static HashMap<String, String> mHashMap = new HashMap<>();

    static {
        mHashMap.put(CODE_200, "200");
        mHashMap.put(CODE_10000, "10000");
        mHashMap.put(CODE_10001, "10001");
    }

    @StringDef({CODE_10000, CODE_10001, CODE_200})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionType {

    }

    public static ResposeBean success(Object object) {
        ResposeBean respose = new ResposeBean();
        respose.setCode(mHashMap.get(CODE_200));
        respose.setMessage(CODE_200);
        respose.setData(object);
        return respose;
    }

    public static ResposeBean success() {
        ResposeBean respose = new ResposeBean();
        respose.setCode(mHashMap.get(CODE_200));
        respose.setMessage(CODE_200);
        return respose;
    }


    public static ResposeBean error(@PermissionType String code) {
        ResposeBean respose = new ResposeBean();
        respose.setCode(mHashMap.get(code));
        respose.setMessage(code);
        return respose;
    }
}
