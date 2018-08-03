package com.fangyi.component_library.func.utils.dbutils.bean;

import java.io.Serializable;

/**
 * Created by fangy on 2017/6/18.
 */

public class DeviceUISet implements Serializable {

    private String id;
    private String user_sys_id;
    private String unkonwn;

    private String kis_name;
    private String table_name;
    private String a_v;
    private String a_d;
    private String b_v;
    private String b_d;

    private String c_v;
    private String c_d;
    private String requester_v;
    private String requester_d;
    private String customer_address_v;
    private String customer_phone_v;

    private String clerk_v;
    private String clerk_d;
    private String d_v;
    private String d_d;
    private String department_v;
    private String department_d;
    private String acceptance_v;
    private String acceptance_d;

    private String custody_v;
    private String custody_d;
    private String warehouse_out_v;
    private String warehouse_out_d;
    private String warehouse_out_position;
    private String e_v;
    private String e_d;
    private String contact_table_v;
    private String contact_table_m;
    private String contact_table_c;
    private String batch;
    private String bill_auto;
    private String whole_pro;
    private String plan_pro;
    private String pro_amount_v;
    private String price_v;
    private String change_price;
    private String date;
    private String check_mode;
    private String upload_mode;
    private String update_type;
    private String delete_table_type;
    private String allow_download_day;
    private String allow_upload_day;
    private String save_print;
    private String print_number_v;
    private String print_number_sheets;


    private String title_0;
    private String title_1;

    private String title_header_0;
    private String title_header_1;
    private String title_header_2;
    private String title_header_3;
    private String title_header_4;
    private String title_header_5;

    private String title_footer_0;
    private String title_footer_1;
    private String title_footer_2;
    private String title_footer_3;
    private String title_footer_4;

    private String warehouse_in_v;
    private String warehouse_in_d;
    private String warehouse_in_position;

    @Override
    public String toString() {
        return "DeviceUISet{" +
                "id='" + id + '\'' +
                ", user_sys_id='" + user_sys_id + '\'' +
                ", unkonwn='" + unkonwn + '\'' +
                ", kis_name='" + kis_name + '\'' +
                ", table_name='" + table_name + '\'' +
                ", a_v='" + a_v + '\'' +
                ", a_d='" + a_d + '\'' +
                ", b_v='" + b_v + '\'' +
                ", b_d='" + b_d + '\'' +
                ", c_v='" + c_v + '\'' +
                ", c_d='" + c_d + '\'' +
                ", requester_v='" + requester_v + '\'' +
                ", requester_d='" + requester_d + '\'' +
                ", client_address_v='" + customer_address_v + '\'' +
                ", client_phone_v='" + customer_phone_v + '\'' +
                ", clerk_v='" + clerk_v + '\'' +
                ", clerk_d='" + clerk_d + '\'' +
                ", d_v='" + d_v + '\'' +
                ", d_d='" + d_d + '\'' +
                ", department_v='" + department_v + '\'' +
                ", department_d='" + department_d + '\'' +
                ", acceptance_v='" + acceptance_v + '\'' +
                ", acceptance_d='" + acceptance_d + '\'' +
                ", custody_v='" + custody_v + '\'' +
                ", custody_d='" + custody_d + '\'' +
                ", warehouse_out_v='" + warehouse_out_v + '\'' +
                ", warehouse_out_d='" + warehouse_out_d + '\'' +
                ", warehouse_out_position='" + warehouse_out_position + '\'' +
                ", e_v='" + e_v + '\'' +
                ", e_d='" + e_d + '\'' +
                ", contact_table_v='" + contact_table_v + '\'' +
                ", contact_table_m='" + contact_table_m + '\'' +
                ", contact_table_c='" + contact_table_c + '\'' +
                ", batch='" + batch + '\'' +
                ", bill_auto='" + bill_auto + '\'' +
                ", whole_pro='" + whole_pro + '\'' +
                ", plan_pro='" + plan_pro + '\'' +
                ", pro_amount_v='" + pro_amount_v + '\'' +
                ", price_v='" + price_v + '\'' +
                ", change_price='" + change_price + '\'' +
                ", date='" + date + '\'' +
                ", check_mode='" + check_mode + '\'' +
                ", upload_mode='" + upload_mode + '\'' +
                ", update_type='" + update_type + '\'' +
                ", delete_table_type='" + delete_table_type + '\'' +
                ", allow_download_day='" + allow_download_day + '\'' +
                ", allow_upload_day='" + allow_upload_day + '\'' +
                ", save_print='" + save_print + '\'' +
                ", print_number_v='" + print_number_v + '\'' +
                ", print_number_sheets='" + print_number_sheets + '\'' +
                ", title_0='" + title_0 + '\'' +
                ", title_1='" + title_1 + '\'' +
                ", title_header_0='" + title_header_0 + '\'' +
                ", title_header_1='" + title_header_1 + '\'' +
                ", title_header_2='" + title_header_2 + '\'' +
                ", title_header_3='" + title_header_3 + '\'' +
                ", title_header_4='" + title_header_4 + '\'' +
                ", title_header_5='" + title_header_5 + '\'' +
                ", title_footer_0='" + title_footer_0 + '\'' +
                ", title_footer_1='" + title_footer_1 + '\'' +
                ", title_footer_2='" + title_footer_2 + '\'' +
                ", title_footer_3='" + title_footer_3 + '\'' +
                ", title_footer_4='" + title_footer_4 + '\'' +
                ", warehouse_in_v='" + warehouse_in_v + '\'' +
                ", warehouse_in_d='" + warehouse_in_d + '\'' +
                ", warehouse_in_position='" + warehouse_in_position + '\'' +
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

    public String getUnkonwn() {
        return unkonwn;
    }

    public void setUnkonwn(String unkonwn) {
        this.unkonwn = unkonwn;
    }

    public String getKis_name() {
        return kis_name;
    }

    public void setKis_name(String kis_name) {
        this.kis_name = kis_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getA_v() {
        return a_v;
    }

    public void setA_v(String a_v) {
        this.a_v = a_v;
    }

    public String getA_d() {
        return a_d;
    }

    public void setA_d(String a_d) {
        this.a_d = a_d;
    }

    public String getB_v() {
        return b_v;
    }

    public void setB_v(String b_v) {
        this.b_v = b_v;
    }

    public String getB_d() {
        return b_d;
    }

    public void setB_d(String b_d) {
        this.b_d = b_d;
    }

    public String getC_v() {
        return c_v;
    }

    public void setC_v(String c_v) {
        this.c_v = c_v;
    }

    public String getC_d() {
        return c_d;
    }

    public void setC_d(String c_d) {
        this.c_d = c_d;
    }

    public String getRequester_v() {
        return requester_v;
    }

    public void setRequester_v(String requester_v) {
        this.requester_v = requester_v;
    }

    public String getRequester_d() {
        return requester_d;
    }

    public void setRequester_d(String requester_d) {
        this.requester_d = requester_d;
    }

    public String getCustomer_address_v() {
        return customer_address_v;
    }

    public void setCustomer_address_v(String client_address_v) {
        this.customer_address_v = client_address_v;
    }

    public String getCustomer_phone_v() {
        return customer_phone_v;
    }

    public void setCustomer_phone_v(String client_phone_v) {
        this.customer_phone_v = client_phone_v;
    }

    public String getClerk_v() {
        return clerk_v;
    }

    public void setClerk_v(String clerk_v) {
        this.clerk_v = clerk_v;
    }

    public String getClerk_d() {
        return clerk_d;
    }

    public void setClerk_d(String clerk_d) {
        this.clerk_d = clerk_d;
    }

    public String getD_v() {
        return d_v;
    }

    public void setD_v(String d_v) {
        this.d_v = d_v;
    }

    public String getD_d() {
        return d_d;
    }

    public void setD_d(String d_d) {
        this.d_d = d_d;
    }

    public String getDepartment_v() {
        return department_v;
    }

    public void setDepartment_v(String department_v) {
        this.department_v = department_v;
    }

    public String getDepartment_d() {
        return department_d;
    }

    public void setDepartment_d(String department_d) {
        this.department_d = department_d;
    }

    public String getAcceptance_v() {
        return acceptance_v;
    }

    public void setAcceptance_v(String acceptance_v) {
        this.acceptance_v = acceptance_v;
    }

    public String getAcceptance_d() {
        return acceptance_d;
    }

    public void setAcceptance_d(String acceptance_d) {
        this.acceptance_d = acceptance_d;
    }

    public String getCustody_v() {
        return custody_v;
    }

    public void setCustody_v(String custody_v) {
        this.custody_v = custody_v;
    }

    public String getCustody_d() {
        return custody_d;
    }

    public void setCustody_d(String custody_d) {
        this.custody_d = custody_d;
    }

    public String getWarehouse_out_v() {
        return warehouse_out_v;
    }

    public void setWarehouse_out_v(String warehouse_out_v) {
        this.warehouse_out_v = warehouse_out_v;
    }

    public String getWarehouse_out_d() {
        return warehouse_out_d;
    }

    public void setWarehouse_out_d(String warehouse_out_d) {
        this.warehouse_out_d = warehouse_out_d;
    }

    public String getWarehouse_out_position() {
        return warehouse_out_position;
    }

    public void setWarehouse_out_position(String warehouse_out_position) {
        this.warehouse_out_position = warehouse_out_position;
    }

    public String getE_v() {
        return e_v;
    }

    public void setE_v(String e_v) {
        this.e_v = e_v;
    }

    public String getE_d() {
        return e_d;
    }

    public void setE_d(String e_d) {
        this.e_d = e_d;
    }

    public String getContact_table_v() {
        return contact_table_v;
    }

    public void setContact_table_v(String contact_table_v) {
        this.contact_table_v = contact_table_v;
    }

    public String getContact_table_m() {
        return contact_table_m;
    }

    public void setContact_table_m(String contact_table_m) {
        this.contact_table_m = contact_table_m;
    }

    public String getContact_table_c() {
        return contact_table_c;
    }

    public void setContact_table_c(String contact_table_c) {
        this.contact_table_c = contact_table_c;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBill_auto() {
        return bill_auto;
    }

    public void setBill_auto(String bill_auto) {
        this.bill_auto = bill_auto;
    }

    public String getWhole_pro() {
        return whole_pro;
    }

    public void setWhole_pro(String whole_pro) {
        this.whole_pro = whole_pro;
    }

    public String getPlan_pro() {
        return plan_pro;
    }

    public void setPlan_pro(String plan_pro) {
        this.plan_pro = plan_pro;
    }

    public String getPro_amount_v() {
        return pro_amount_v;
    }

    public void setPro_amount_v(String pro_amount_v) {
        this.pro_amount_v = pro_amount_v;
    }

    public String getPrice_v() {
        return price_v;
    }

    public void setPrice_v(String price_v) {
        this.price_v = price_v;
    }

    public String getChange_price() {
        return change_price;
    }

    public void setChange_price(String change_price) {
        this.change_price = change_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheck_mode() {
        return check_mode;
    }

    public void setCheck_mode(String check_mode) {
        this.check_mode = check_mode;
    }

    public String getUpload_mode() {
        return upload_mode;
    }

    public void setUpload_mode(String upload_mode) {
        this.upload_mode = upload_mode;
    }

    public String getUpdate_type() {
        return update_type;
    }

    public void setUpdate_type(String update_type) {
        this.update_type = update_type;
    }

    public String getDelete_table_type() {
        return delete_table_type;
    }

    public void setDelete_table_type(String delete_table_type) {
        this.delete_table_type = delete_table_type;
    }

    public String getAllow_download_day() {
        return allow_download_day;
    }

    public void setAllow_download_day(String allow_download_day) {
        this.allow_download_day = allow_download_day;
    }

    public String getAllow_upload_day() {
        return allow_upload_day;
    }

    public void setAllow_upload_day(String allow_upload_day) {
        this.allow_upload_day = allow_upload_day;
    }

    public String getSave_print() {
        return save_print;
    }

    public void setSave_print(String save_print) {
        this.save_print = save_print;
    }

    public String getPrint_number_v() {
        return print_number_v;
    }

    public void setPrint_number_v(String print_number_v) {
        this.print_number_v = print_number_v;
    }

    public String getPrint_number_sheets() {
        return print_number_sheets;
    }

    public void setPrint_number_sheets(String print_number_sheets) {
        this.print_number_sheets = print_number_sheets;
    }

    public String getTitle_0() {
        return title_0;
    }

    public void setTitle_0(String title_0) {
        this.title_0 = title_0;
    }

    public String getTitle_1() {
        return title_1;
    }

    public void setTitle_1(String title_1) {
        this.title_1 = title_1;
    }

    public String getTitle_header_0() {
        return title_header_0;
    }

    public void setTitle_header_0(String title_header_0) {
        this.title_header_0 = title_header_0;
    }

    public String getTitle_header_1() {
        return title_header_1;
    }

    public void setTitle_header_1(String title_header_1) {
        this.title_header_1 = title_header_1;
    }

    public String getTitle_header_2() {
        return title_header_2;
    }

    public void setTitle_header_2(String title_header_2) {
        this.title_header_2 = title_header_2;
    }

    public String getTitle_header_3() {
        return title_header_3;
    }

    public void setTitle_header_3(String title_header_3) {
        this.title_header_3 = title_header_3;
    }

    public String getTitle_header_4() {
        return title_header_4;
    }

    public void setTitle_header_4(String title_header_4) {
        this.title_header_4 = title_header_4;
    }

    public String getTitle_header_5() {
        return title_header_5;
    }

    public void setTitle_header_5(String title_header_5) {
        this.title_header_5 = title_header_5;
    }

    public String getTitle_footer_0() {
        return title_footer_0;
    }

    public void setTitle_footer_0(String title_footer_0) {
        this.title_footer_0 = title_footer_0;
    }

    public String getTitle_footer_1() {
        return title_footer_1;
    }

    public void setTitle_footer_1(String title_footer_1) {
        this.title_footer_1 = title_footer_1;
    }

    public String getTitle_footer_2() {
        return title_footer_2;
    }

    public void setTitle_footer_2(String title_footer_2) {
        this.title_footer_2 = title_footer_2;
    }

    public String getTitle_footer_3() {
        return title_footer_3;
    }

    public void setTitle_footer_3(String title_footer_3) {
        this.title_footer_3 = title_footer_3;
    }

    public String getTitle_footer_4() {
        return title_footer_4;
    }

    public void setTitle_footer_4(String title_footer_4) {
        this.title_footer_4 = title_footer_4;
    }

    public String getWarehouse_in_v() {
        return warehouse_in_v;
    }

    public void setWarehouse_in_v(String warehouse_in_v) {
        this.warehouse_in_v = warehouse_in_v;
    }

    public String getWarehouse_in_d() {
        return warehouse_in_d;
    }

    public void setWarehouse_in_d(String warehouse_in_d) {
        this.warehouse_in_d = warehouse_in_d;
    }

    public String getWarehouse_in_position() {
        return warehouse_in_position;
    }

    public void setWarehouse_in_position(String warehouse_in_position) {
        this.warehouse_in_position = warehouse_in_position;
    }
}
