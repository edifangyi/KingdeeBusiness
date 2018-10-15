package com.fangyi.component_library.func.utils.baserx;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 */
public class ResposeBean<T> implements Serializable {
    public String code;
    public String message;

    public T data;

    public boolean success() {
        return ResponseUtil.CODE_200.equals(message);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "success='" + code + '\'' +
                ", msg='" + message + '\'' +
                ", obj=" + data +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
