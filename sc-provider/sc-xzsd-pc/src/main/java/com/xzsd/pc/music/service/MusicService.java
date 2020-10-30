package com.xzsd.pc.music.service;

import com.xzsd.pc.music.dao.MusicDao;
import com.xzsd.pc.music.entity.MusicInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class MusicService {

    @Resource
    private MusicDao musicDao;

    /**
     * 新增音乐
     * wumaoxing
     * 2020-10-16 22:13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMusic(MusicInfo musicInfo){
        musicInfo.setMusicId(StringUtil.getCommonCode(2));
        // 新增文件
        int count = musicDao.addMusic(musicInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 获取音乐列表
     * wumaoxing
     * 2020-10-16 22:22
     */
    public AppResponse listMusics( ) {
        List<MusicInfo> musicInfoList = musicDao.listMusics();
        return AppResponse.success("查询成功！", getPageInfo(musicInfoList));
    }
}
