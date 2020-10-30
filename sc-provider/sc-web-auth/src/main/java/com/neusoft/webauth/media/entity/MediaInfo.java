package com.neusoft.webauth.media.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class MediaInfo {
    /**
     * 媒体编号
     */
    private String mediaId;
    /**
     * 媒体路径
     */
    private String mediaUrl;
    /**
     * 文件
     */
    private MultipartFile file;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 头像
     */
    private String photo;
    /**
     * 媒体介绍
     */
    private String mediaIntroduce;
    /**
     * 媒体缩略图
     */
    private String mediaThumb;
    /**
     * 是否为缩略图 0否 1是
     */
    private String isMediaThumb;
    /**
     * 音乐编号
     */
    private String musicId;
    /**
     * 音乐路径
     */
    private String musicUrl;
    /**
     * 音乐名字
     */
    private String musicName;
    /**
     * 音乐海报
     */
    private String musicPoster;
    /**
     * 点赞数量
     */
    private String likeNumber;
    /**
     * 评论数量
     */
    private String commentNumber;
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

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMediaIntroduce() {
        return mediaIntroduce;
    }

    public void setMediaIntroduce(String mediaIntroduce) {
        this.mediaIntroduce = mediaIntroduce;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMusicPoster() {
        return musicPoster;
    }

    public void setMusicPoster(String musicPoster) {
        this.musicPoster = musicPoster;
    }

    public String getMediaThumb() {
        return mediaThumb;
    }

    public void setMediaThumb(String mediaThumb) {
        this.mediaThumb = mediaThumb;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getIsMediaThumb() {
        return isMediaThumb;
    }

    public void setIsMediaThumb(String isMediaThumb) {
        this.isMediaThumb = isMediaThumb;
    }
}
