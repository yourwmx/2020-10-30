package com.xzsd.pc.music.dao;

import com.xzsd.pc.music.entity.MusicInfo;

import java.util.List;

public interface MusicDao {
    /**
     * 新增音乐
     * wumaoxing
     * 2020-10-16 22:23
     */
    int addMusic(MusicInfo musicInfo);
    /**
     * 查询音乐列表
     * wumaoxing
     * 2020-10-16 22:24
     */
    List<MusicInfo> listMusics();
}
