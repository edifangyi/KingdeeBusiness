package com.fangyi.component_library.func.utils.dbutils.bean;

/**
 * Created by FANGYI on 2016/9/8.
 */

public class DeviceBill {

    private String id;
    private String user_sys_id;    //用户标号
    private String company_name; //公司名称
    private String auto_wifi;     //仅WIFI环境上传下载
    private String auto_login; //系统自动登陆
    private String server_ip;    //服务器地址
    private String auto_notice;      //启用通知
    private String imei;        //手机IMEI
    private String registration_code;      //注册码
    private String version;
    private String font_title;
    private String font_entry;
    private String font_header;
    private String font_footer;


    @Override
    public String toString() {
        return "DeviceBill{" +
                "id='" + id + '\'' +
                ", user_sys_id='" + user_sys_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", auto_wifi='" + auto_wifi + '\'' +
                ", auto_login='" + auto_login + '\'' +
                ", server_ip='" + server_ip + '\'' +
                ", auto_notice='" + auto_notice + '\'' +
                ", imei='" + imei + '\'' +
                ", registration_code='" + registration_code + '\'' +
                ", version='" + version + '\'' +
                ", font_title='" + font_title + '\'' +
                ", font_entry='" + font_entry + '\'' +
                ", font_header='" + font_header + '\'' +
                ", font_footer='" + font_footer + '\'' +
                '}';
    }

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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAuto_wifi() {
        return auto_wifi;
    }

    public void setAuto_wifi(String auto_wifi) {
        this.auto_wifi = auto_wifi;
    }

    public String getAuto_login() {
        return auto_login;
    }

    public void setAuto_login(String auto_login) {
        this.auto_login = auto_login;
    }

    public String getServer_ip() {
        return server_ip;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
    }

    public String getAuto_notice() {
        return auto_notice;
    }

    public void setAuto_notice(String auto_notice) {
        this.auto_notice = auto_notice;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRegistration_code() {
        return registration_code;
    }

    public void setRegistration_code(String registration_code) {
        this.registration_code = registration_code;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFont_title() {
        return font_title;
    }

    public void setFont_title(String font_title) {
        this.font_title = font_title;
    }

    public String getFont_entry() {
        return font_entry;
    }

    public void setFont_entry(String font_entry) {
        this.font_entry = font_entry;
    }

    public String getFont_header() {
        return font_header;
    }

    public void setFont_header(String font_header) {
        this.font_header = font_header;
    }

    public String getFont_footer() {
        return font_footer;
    }

    public void setFont_footer(String font_footer) {
        this.font_footer = font_footer;
    }
}
