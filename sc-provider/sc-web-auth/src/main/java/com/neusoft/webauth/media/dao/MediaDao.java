package com.neusoft.webauth.media.dao;

import com.neusoft.webauth.media.entity.MediaInfo;

import java.util.List;

public interface MediaDao {
    /**
     * 获取文件列表
     * wumaoxing
     * 2020-10-15 22:06
     */
    List<MediaInfo> listMedias(MediaInfo mediaInfo);
}
