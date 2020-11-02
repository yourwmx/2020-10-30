package com.xzsd.pc.media.service;

import com.xzsd.pc.media.dao.MediaDao;
import com.xzsd.pc.media.entity.MediaInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class MediaService {

    @Resource
    private MediaDao mediaDao;

    /**
     * 新增文件
     * wumaoxing
     * 2020-10-15 19:58
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMedia(MediaInfo mediaInfo){
        // 新增文件
        int count = mediaDao.addMedia(mediaInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 获取文件列表
     * wumaoxing
     * 2020-10-15 22:04
     */
    public AppResponse listMedias(List<String> listUserId) {
        List<MediaInfo> mediaInfoList = mediaDao.listMedias(listUserId);
        return AppResponse.success("查询成功！", getPageInfo(mediaInfoList));
    }

    /**
     * 删除文件
     * wumaoxing
     * 2020-10-24 15:59
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMedia(String mediaId,String updateUserId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        List<String> listDeleteMediaId = Arrays.asList(mediaId.split(","));
        int count = mediaDao.deleteMedia(listDeleteMediaId,updateUserId);
        if(0 == count) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
