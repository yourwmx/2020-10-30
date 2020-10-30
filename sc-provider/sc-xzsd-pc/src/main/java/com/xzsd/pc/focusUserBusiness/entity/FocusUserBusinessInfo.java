package com.xzsd.pc.focusUserBusiness.entity;

import java.util.Date;

public class FocusUserBusinessInfo {
    /**
     * 关注用户编号
     */
    private String focusUserBusinessId;
    /**
     * 关注人
     */
    private String focusUserId;
    /**
     * 被关注人
     */
    private String beFocusUserId;
    /**
     * 删除标记 0未删 1删
     */
    private int isDeleted;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改人
     */
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 版本号
     */
    private String version;

    public String getFocusUserBusinessId() {
        return focusUserBusinessId;
    }

    public void setFocusUserBusinessId(String focusUserBusinessId) {
        this.focusUserBusinessId = focusUserBusinessId;
    }

    public String getFocusUserId() {
        return focusUserId;
    }

    public void setFocusUserId(String focusUserId) {
        this.focusUserId = focusUserId;
    }

    public String getBeFocusUserId() {
        return beFocusUserId;
    }

    public void setBeFocusUserId(String beFocusUserId) {
        this.beFocusUserId = beFocusUserId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
