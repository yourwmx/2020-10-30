package com.xzsd.pc.likeCommentBusiness.service;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.likeCommentBusiness.dao.LikeCommentBusinessDao;
import com.xzsd.pc.likeCommentBusiness.entity.LikeCommentBusinessInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class LikeCommentBusinessService {

    @Resource
    private LikeCommentBusinessDao likeCommentBusinessDao;

    /**
     * 获取点赞评论业务编号
     * wumaoxing
     * 2020-10-30 11:23
     */
    public AppResponse queryLikeCommentBusinessId(String commentId, String userId) {
        List<String> listCommentId = Arrays.asList(commentId.split(","));
        return AppResponse.success("查询成功！", likeCommentBusinessDao.queryLikeCommentBusinessId(listCommentId, userId));
    }

    /**
     * 未点赞->点赞
     * wumaoxing
     * 2020-10-30 11:23
     */
    public AppResponse addLikeCommentBusiness(LikeCommentBusinessInfo likeCommentBusinessInfo) {
        likeCommentBusinessInfo.setCreateBy(likeCommentBusinessInfo.getLikeUserId());
        likeCommentBusinessInfo.setLikeCommentBusinessId(StringUtil.getCommonCode(2));
        // 新增数据
        int count = likeCommentBusinessDao.addLikeCommentBusiness(likeCommentBusinessInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 点赞->取消点赞
     * wumaoxing
     * 2020-10-30 11:23
     */
    public AppResponse deleteLikeCommentBusiness(LikeCommentBusinessInfo likeCommentBusinessInfo) {
        likeCommentBusinessInfo.setLastModifiedBy(likeCommentBusinessInfo.getLikeUserId());
        // 删除数据
        int count = likeCommentBusinessDao.deleteLikeCommentBusiness(likeCommentBusinessInfo);
        if(0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
}
