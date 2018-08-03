package com.fangyi.component_library.func.utils.baserx;


public class ResponseUtil {


    public static ResposeBean success(Object object) {
        ResposeBean result = new ResposeBean();
        result.setCode("100");
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static ResposeBean success() {
        ResposeBean result = new ResposeBean();
        result.setCode("100");
        result.setMessage("成功");
        return result;
    }


    public static ResposeBean error(String code, String mesg) {
        ResposeBean result = new ResposeBean();
        result.setCode(code);
        result.setMessage(mesg);
        return result;
    }
}
