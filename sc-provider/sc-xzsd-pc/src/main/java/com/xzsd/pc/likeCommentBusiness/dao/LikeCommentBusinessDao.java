package com.xzsd.pc.likeCommentBusiness.dao;

import com.xzsd.pc.likeCommentBusiness.entity.LikeCommentBusinessInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeCommentBusinessDao {
    /**
     * 获取点赞媒体业务编号
     * wumaoxing
     * 2020-11-30 11:28
     */
    List<LikeCommentBusinessInfo> queryLikeCommentBusinessId(@Param("listCommentId") List<String> listCommentId, @Param("userId") String userId);
    /**
     * 未点赞->点赞
     * wumaoxing
     * 2020-11-30 16:28
     */
    int addLikeCommentBusiness(LikeCommentBusinessInfo likeCommentBusinessInfo);
    /**
     * 点赞->取消点赞
     * wumaoxing
     * 2020-10-30 11:28
     */
    int deleteLikeCommentBusiness(LikeCommentBusinessInfo likeCommentBusinessInfo);
}
