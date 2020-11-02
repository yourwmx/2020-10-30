package com.xzsd.pc.media.dao;

import com.xzsd.pc.media.entity.MediaInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MediaDao {
    /**
     * 新增文件
     * wumaoxing
     * 2020-10-15 19:58
     */
    int addMedia(MediaInfo mediaInfo);
    /**
     * 获取文件列表
     * wumaoxing
     * 2020-10-15 22:06
     */
    List<MediaInfo> listMedias(List<String> listUserId);
    /**
     * 删除文件信息
     * wumaoxing
     * 2020-10-24 16:01
     */
    int deleteMedia(@Param("listDeleteMediaId") List<String> listDeleteMediaId, @Param("updateUserId") String updateUserId);
}
