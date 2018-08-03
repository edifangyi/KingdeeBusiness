package com.fangyi.component_library.func.utils.update;

/**
 * ================================================
 * 作    者：FANGYI <87649669@qq.com>
 * 版    本：1.0.0
 * 日    期：2018/7/7
 * 说    明：
 * ================================================
 */
public class UpdateBean {

    /**
     * IsLatest : false
     * IsForced : false
     * NewVersion : 1.0.1
     * UpdateContent : 1.测试一下；\n2.在测试一下
     * ApkUrl : http://211.149.200.136:5678/nedu.apk
     * ApkSize : 15.83M
     */

    private boolean IsLatest;//是否是最新的
    private boolean IsForced;//是否强制升级
    private String NewVersion;//版本号
    private String UpdateContent;//升级日志
    private String ApkUrl;//下载链接
    private String ApkSize;//安装包大小


    public boolean isLatest() {
        return IsLatest;
    }

    public void setLatest(boolean latest) {
        IsLatest = latest;
    }

    public boolean isForced() {
        return IsForced;
    }

    public void setForced(boolean forced) {
        IsForced = forced;
    }

    public String getNewVersion() {
        return NewVersion;
    }

    public void setNewVersion(String newVersion) {
        NewVersion = newVersion;
    }

    public String getUpdateContent() {
        return UpdateContent;
    }

    public void setUpdateContent(String updateContent) {
        UpdateContent = updateContent;
    }

    public String getApkUrl() {
        return ApkUrl;
    }

    public void setApkUrl(String apkUrl) {
        ApkUrl = apkUrl;
    }

    public String getApkSize() {
        return ApkSize;
    }

    public void setApkSize(String apkSize) {
        ApkSize = apkSize;
    }
}
