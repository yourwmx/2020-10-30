package com.xzsd.pc.likeMediaBusiness.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.likeMediaBusiness.dao.LikeMediaBusinessDao;
import com.xzsd.pc.likeMediaBusiness.entity.LikeMediaBusinessInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class LikeMediaBusinessService {

    @Resource
    private LikeMediaBusinessDao likeMediaBusinessDao;

    /**
     * 获取点赞媒体业务编号
     * wumaoxing
     * 2020-10-25 18:57
     */
    public AppResponse queryLikeMediaBusinessId(String mediaId, String userId) {
        List<String> listMediaId = Arrays.asList(mediaId.split(","));
        return AppResponse.success("查询成功！", likeMediaBusinessDao.queryLikeMediaBusinessId(listMediaId, userId));
    }

    /**
     * 未点赞->点赞
     * wumaoxing
     * 2020-10-26 16:23
     */
    public AppResponse addLikeMediaBusiness(LikeMediaBusinessInfo likeMediaBusinessInfo) {
        likeMediaBusinessInfo.setCreateBy(likeMediaBusinessInfo.getLikeUserId());
        likeMediaBusinessInfo.setLikeMediaBusinessId(StringUtil.getCommonCode(2));
        // 新增数据
        int count = likeMediaBusinessDao.addLikeMediaBusiness(likeMediaBusinessInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 点赞->取消点赞
     * wumaoxing
     * 2020-10-26 17:09
     */
    public AppResponse deleteLikeMediaBusiness(LikeMediaBusinessInfo likeMediaBusinessInfo) {
        likeMediaBusinessInfo.setLastModifiedBy(likeMediaBusinessInfo.getLikeUserId());
        // 删除数据
        int count = likeMediaBusinessDao.deleteLikeMediaBusiness(likeMediaBusinessInfo);
        if(0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
}
