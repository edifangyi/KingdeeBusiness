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

    private boolean isLatest;//是否是最新的
    private boolean isForced;//是否强制升级
    private String newVersion;//版本号
    private String updateContent;//升级日志
    private String apkUrl;//下载链接
    private String apkSize;//安装包大小

    public boolean isLatest() {
        return isLatest;
    }

    public void setLatest(boolean latest) {
        isLatest = latest;
    }

    public boolean isForced() {
        return isForced;
    }

    public void setForced(boolean forced) {
        isForced = forced;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getApkSize() {
        return apkSize;
    }

    public void setApkSize(String apkSize) {
        this.apkSize = apkSize;
    }
}
