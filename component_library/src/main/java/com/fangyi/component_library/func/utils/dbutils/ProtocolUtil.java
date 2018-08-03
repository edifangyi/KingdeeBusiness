package com.fangyi.component_library.func.utils.dbutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FANGYI on 2016/9/4.
 */

public class ProtocolUtil {
    private static String usersSql = "insert into Users(user_sys_id,kis_id,user_sys_password,kis_name,kis_password,unkonwn_0,unkonwn_1,unkonwn_2,login_time) values(#fieldNames#)";

    private static String deviceuiSql = "insert into deviceui(user_sys_id,kis_name,table_22,table_23,table_24,table_25,table_stock_query,table_stock_summary,table_26,table_27,table_28,table_29,table_sell_query,table_sell_summary,table_sell_ranking,table_30,table_reserve_query,table_reserve_immediate,table_31,table_32,table_33,table_34) values(#fieldNames#)";
    private static String devicebillSql = "insert into devicebill(user_sys_id,company_name,auto_wifi,auto_login,server_ip,auto_notice,imei,registration_code,version,font_title,font_entry,font_header,font_footer) values(#fieldNames#)";
    private static String devicebillsetSql = "insert into deviceuiset(" +
            "user_sys_id,unkonwn," +
            "kis_name," +
            "table_name," +
            "a_v," +
            "a_d," +
            "b_v," +
            "b_d," +
            "c_v," +
            "c_d," +
            "requester_v," +
            "requester_d," +
            "customer_address_v," +
            "customer_phone_v," +
            "clerk_v," +
            "clerk_d," +
            "d_v,d_d," +
            "department_v," +
            "department_d," +
            "acceptance_v," +
            "acceptance_d," +
            "custody_v," +
            "custody_d," +
            "warehouse_out_v," +
            "warehouse_out_d," +
            "warehouse_out_position," +
            "e_v," +
            "e_d," +
            "contact_table_v," +
            "contact_table_m," +
            "contact_table_c," +
            "batch," +
            "bill_auto," +
            "whole_pro," +
            "plan_pro," +
            "pro_amount_v," +
            "price_v," +
            "change_price," +
            "date," +
            "check_mode," +
            "upload_mode," +
            "update_type," +
            "delete_table_type," +
            "allow_download_day," +
            "allow_upload_day," +
            "save_print," +
            "print_number_v," +
            "print_number_sheets," +
            "title_0," +
            "title_1," +
            "title_header_0," +
            "title_header_1," +
            "title_header_2," +
            "title_header_3," +
            "title_header_4," +
            "title_header_5," +
            "title_footer_0," +
            "title_footer_1," +
            "title_footer_2," +
            "title_footer_3," +
            "title_footer_4," +
            "warehouse_in_v," +
            "warehouse_in_d," +
            "warehouse_in_position) values(#fieldNames#)";

    private static String customerSql = "insert into BCustomer(CustomerSysID,CustomerNum,CustomerName,DeptID,DeptName,TypeID,TypeName,IsUsed,Address,Contact,Tel,Mobile,Employee,Etel,Emobile,LastTime) values(#fieldNames#)";
    private static String goodSql = "insert into BGoods(Barcode,GoodsSysID,GoodsID,GoodsName,GoodsFullName,HelpID,RetailPrice,TradePrice,Accuracy,Standard,UnitID,Unit,UnitGroupID,UnitGroup,Conversion,Assist,Category,Warehouse,WarehousePlace,IsUsed,BoxCode,LastTime,OldBarcode,IsDel) values(#fieldNames#)";
    private static String itemPriceSql = "insert into BItemPrice(ID,RelatedID,Priority,ItemID,Uom,BeginSales,EndSales,Currency,PriceType,Price,BeginDate,EndDate,MinPrice,IsMinPriceCtrl,IsChecked,IsUser,PlyType,LastTime,PriceX) values(#fieldNames#)";

    private static String phoneSql = "insert into BPhone(UserSysId,UsuerName,Phone) values(#fieldNames#)";
    private static String usercustomerSql = "insert into BUserCustomer(KisID,CustomerSysID) values(#fieldNames#)";
    private static String parameterSql = "insert into BParameter(Parametertype,ParameterID,ParameterName) values(#fieldNames#)";
    private static String warehouseSql = "insert into BWareHouse(KisID,WareHouseSysID,WareHouseNum,WareHouseName,IsCar) values(#fieldNames#)";

    private static String freebillSql = "insert into BFreeBill(UserSysID,FIndex,Fx,Fy,FIndex2,FName,FSaleType,FSumQty,FSumAmount,FDate,FStarDate,FEndDate,FSuit,FMultiple) values(#fieldNames#)";
    private static String freebilldetailSql = "insert into BFreeBillDetail(UserSysID,FIndex,Fx,FPRoItem,FproUnit,FProQty,FProAmount,FFlag) values(#fieldNames#)";

    private static String unitgroupSql = "insert into BUnitGroup(UnitID,UnitGroupID,Uom,Conversion,Ubase) values(#fieldNames#)";

    private static String seordermainSql = "insert into BSEOrderMain(UserSysID,CustomerName,CustomerSySID,OrderDate,ID,BusinessType,FSaleStyleID,FSaleStyleName,DeptID,KISID,Message,KINGID,AllMoney) values(#fieldNames#)";

    private static String seorderdetailSql = "insert into BSEOrderDetail(UserSysID,ID,GoodsSysID,GoodsName,Standard,UnitID,EntryID,OrderNum,OrderPrice,OrderMoney,OrderFree,ListGoodsType,OrderType,OutNum,NotNum,Uom) values(#fieldNames#)";


    private static String seosrdermainSql = "insert into BSEOsrderMain(UserSysID,CustomerName,CustomerSySID,OrderDate,ID,BusinessType,FSaleStyleID,FSaleStyleName,DeptID,KISID,Message,KINGID,AllMoney) values(#fieldNames#)";

    private static String seosrderdetailSql = "insert into BSEOsrderDetail(UserSysID,ID,GoodsSysID,GoodsName,Standard,UnitID,EntryID,OrderNum,OrderPrice,OrderMoney,OrderFree,ListGoodsType,OrderType,OutNum,NotNum,Uom) values(#fieldNames#)";


    public static List<String> getInsertSQL(String tableName, String protStr) {
        if (tableName == null || tableName.equals(""))
            return null;
        Integer isUsed_index = null;
        String insertSql;

        if (tableName.equals("Users")) {
            insertSql = usersSql;
        } else if (tableName.equals("DeviceUI")) {
            insertSql = deviceuiSql;
        } else if (tableName.equals("DeviceBill")) {
            insertSql = devicebillSql;
        } else if (tableName.equals("DeviceBillSet")) {
            insertSql = devicebillsetSql;
        } else if (tableName.equals("Customer")) {
            insertSql = customerSql;
        } else if (tableName.equals("Goods")) {
            insertSql = goodSql;
        } else if (tableName.equals("ItemPrice")) {
            insertSql = itemPriceSql;
        } else if (tableName.equals("Phone")) {
            insertSql = phoneSql;
        } else if (tableName.equals("UserCustomer")) {
            insertSql = usercustomerSql;
        } else if (tableName.equals("Parameter")) {
            insertSql = parameterSql;
        } else if (tableName.equals("WareHouse")) {
            insertSql = warehouseSql;
        } else if (tableName.equals("FreeBill")) {
            insertSql = freebillSql;
        } else if (tableName.equals("FreeBillDetail")) {
            insertSql = freebilldetailSql;
        } else if (tableName.equals("UnitGroup")) {
            insertSql = unitgroupSql;
        } else if (tableName.equals("Seobill")) {
            insertSql = seordermainSql;
        } else if (tableName.equals("Seobillentry")) {
            insertSql = seorderdetailSql;
        } else if (tableName.equals("Seosbill")) {
            insertSql = seosrdermainSql;
        } else if (tableName.equals("Seosbillentry")) {
            insertSql = seosrderdetailSql;
        } else {
            return null;
        }


        List<String> sqlList = new ArrayList<>();

        protStr = protStr.replace("<1>", "<2>");
        String[] lineStrs = protStr.split("<2>");//将一个字符串分割为子字符串，然后将结果作为字符串数组返回。

        if (lineStrs != null && lineStrs.length > 0)

        {
            for (int i = 1; i < lineStrs.length; i++) {
                String lineStr = "";
                if (lineStrs[i].endsWith("<3>")) {
                    lineStrs[i] = lineStrs[i] + " ";
                }
                String[] itemStrs = lineStrs[i].split("<3>");


                if (isUsed_index != null
                        && itemStrs[isUsed_index] != null
                        && (!tableName.equals("ItemPrice")
                        && itemStrs[isUsed_index].equals("1") || tableName
                        .equals("ItemPrice")
                        && itemStrs[isUsed_index].equals("0")))
                    continue;

                for (String str : itemStrs) {
                    lineStr = lineStr + "'" + str + "'" + ",";
                }
                lineStr = lineStr.substring(0, lineStr.length() - 1);
                sqlList.add(insertSql.replace("#fieldNames#", lineStr));
            }
        }

        return sqlList;
    }


}
