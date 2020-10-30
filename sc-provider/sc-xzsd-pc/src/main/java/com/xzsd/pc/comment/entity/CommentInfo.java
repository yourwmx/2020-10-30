package com.xzsd.pc.comment.entity;

import java.util.Date;
import java.util.List;

public class CommentInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 评论编号
     */
    private String commentId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 被评论人用户编号
     */
    private String beUserId;
    /**
     * 被评论人账号
     */
    private String beUserAccount;
    /**
     * 账号
     */
    private String account;
    /**
     * 头像
     */
    private String photo;
    /**
     * 媒体编号
     */
    private String mediaId;
    /**
     * 评论内容
     */
    private String comment;
    /**
     * 上级评论编号 0代表一级
     */
    private String lastCommentId;
    /**
     * 二级评论列表
     */
    private List<CommentInfo> secondCommentList;
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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLastCommentId() {
        return lastCommentId;
    }

    public void setLastCommentId(String lastCommentId) {
        this.lastCommentId = lastCommentId;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<CommentInfo> getSecondCommentList() {
        return secondCommentList;
    }

    public void setSecondCommentList(List<CommentInfo> secondCommentList) {
        this.secondCommentList = secondCommentList;
    }

    public String getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(String beUserId) {
        this.beUserId = beUserId;
    }

    public String getBeUserAccount() {
        return beUserAccount;
    }

    public void setBeUserAccount(String beUserAccount) {
        this.beUserAccount = beUserAccount;
    }
}
