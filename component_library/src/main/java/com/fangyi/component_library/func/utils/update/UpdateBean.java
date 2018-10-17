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
     * isLatest : false
     * isForced : false
     * newVersion : 1.0.1
     * updateContent : 1.测试一下；\n2.在测试一下
     * apkUrl : http://211.149.200.136:5678/nedu.apk
     * apkSize : 15.83M
     */

    private boolean isLatest;
    private boolean isForced;
    private String newVersion;
    private String updateContent;
    private String apkUrl;
    private String apkSize;

    public boolean isIsLatest() {
        return isLatest;
    }

    public void setIsLatest(boolean isLatest) {
        this.isLatest = isLatest;
    }

    public boolean isIsForced() {
        return isForced;
    }

    public void setIsForced(boolean isForced) {
        this.isForced = isForced;
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
