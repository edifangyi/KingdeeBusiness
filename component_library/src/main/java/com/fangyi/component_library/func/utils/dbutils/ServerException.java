package com.fangyi.component_library.func.utils.dbutils;

/**
 * des:服务器请求异常
 * Created by xsf
 * on 2016.09.10:16
 */
public class ServerException extends Exception {
    private String code;

    public ServerException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
