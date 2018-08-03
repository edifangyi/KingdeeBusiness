package com.fangyi.component_library.func.utils.dbutils.bean;

/**
 * Created by FANGYI on 2016/9/21.
 */

public class Users {
    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", user_sys_id='" + user_sys_id + '\'' +
                ", user_sys_password='" + user_sys_password + '\'' +
                ", kis_id='" + kis_id + '\'' +
                ", kis_name='" + kis_name + '\'' +
                ", kis_password='" + kis_password + '\'' +
                ", unkonwn_0='" + unkonwn_0 + '\'' +
                ", unkonwn_1='" + unkonwn_1 + '\'' +
                ", unkonwn_2='" + unkonwn_2 + '\'' +
                ", login_time='" + login_time + '\'' +
                '}';
    }

    private String id;
    private String user_sys_id;//登陆用户ID
    private String kis_id;//金蝶ID
    private String user_sys_password;//登陆用户ID
    private String kis_name;//金蝶Name
    private String kis_password;
    private String unkonwn_0;
    private String unkonwn_1;
    private String unkonwn_2;
    private String login_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_sys_id() {
        return user_sys_id;
    }

    public void setUser_sys_id(String user_sys_id) {
        this.user_sys_id = user_sys_id;
    }

    public String getUser_sys_password() {
        return user_sys_password;
    }

    public void setUser_sys_password(String user_sys_password) {
        this.user_sys_password = user_sys_password;
    }

    public String getKis_id() {
        return kis_id;
    }

    public void setKis_id(String kis_id) {
        this.kis_id = kis_id;
    }

    public String getKis_name() {
        return kis_name;
    }

    public void setKis_name(String kis_name) {
        this.kis_name = kis_name;
    }

    public String getKis_password() {
        return kis_password;
    }

    public void setKis_password(String kis_password) {
        this.kis_password = kis_password;
    }

    public String getUnkonwn_0() {
        return unkonwn_0;
    }

    public void setUnkonwn_0(String unkonwn_0) {
        this.unkonwn_0 = unkonwn_0;
    }

    public String getUnkonwn_1() {
        return unkonwn_1;
    }

    public void setUnkonwn_1(String unkonwn_1) {
        this.unkonwn_1 = unkonwn_1;
    }

    public String getUnkonwn_2() {
        return unkonwn_2;
    }

    public void setUnkonwn_2(String unkonwn_2) {
        this.unkonwn_2 = unkonwn_2;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }
}
