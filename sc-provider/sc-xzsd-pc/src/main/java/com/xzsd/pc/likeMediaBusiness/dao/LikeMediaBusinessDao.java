package com.xzsd.pc.likeMediaBusiness.dao;

import com.xzsd.pc.likeMediaBusiness.entity.LikeMediaBusinessInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeMediaBusinessDao {
    /**
     * 获取点赞媒体业务编号
     * wumaoxing
     * 2020-10-25 19:02
     */
    List<LikeMediaBusinessInfo> queryLikeMediaBusinessId(@Param("listMediaId") List<String> listMediaId, @Param("userId") String userId);
    /**
     * 未点赞->点赞
     * wumaoxing
     * 2020-10-26 16:31
     */
    int addLikeMediaBusiness(LikeMediaBusinessInfo likeMediaBusinessInfo);
    /**
     * 点赞->取消点赞
     * wumaoxing
     * 2020-10-26 17:10
     */
    int deleteLikeMediaBusiness(LikeMediaBusinessInfo likeMediaBusinessInfo);
}
