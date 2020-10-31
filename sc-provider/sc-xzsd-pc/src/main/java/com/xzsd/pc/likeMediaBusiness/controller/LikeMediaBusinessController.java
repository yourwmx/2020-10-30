package com.xzsd.pc.likeMediaBusiness.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.likeMediaBusiness.entity.LikeMediaBusinessInfo;
import com.xzsd.pc.likeMediaBusiness.service.LikeMediaBusinessService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("likeMediaBusiness")
public class LikeMediaBusinessController {

    private static final Logger logger = LoggerFactory.getLogger(LikeMediaBusinessController.class);

    @Resource
    private LikeMediaBusinessService likeMediaBusinessService;

    /**
     * 获取点赞媒体业务编号
     * wumaoxing
     * 2020-10-25 18:51
     */
    @RequestMapping("queryLikeMediaBusinessId")
    public AppResponse queryLikeMediaBusinessId(String mediaId, String userId) {
        try {
            return likeMediaBusinessService.queryLikeMediaBusinessId(mediaId, userId);
        } catch (Exception e) {
            logger.error("获取点赞媒体业务编号成功", e);
            throw new ScServerException("查询错误，请重试");
        }
    }

    /**
     * 未点赞->点赞
     * wumaoxing
     * 2020-10-26 16:17
     */
    @PostMapping("addLikeMediaBusiness")
    public AppResponse addLikeMediaBusiness(LikeMediaBusinessInfo likeMediaBusinessInfo) {
        try {
            return likeMediaBusinessService.addLikeMediaBusiness(likeMediaBusinessInfo);
        } catch (Exception e) {
            logger.error("未点赞->点赞成功", e);
            throw new ScServerException("未点赞->点赞错误，请重试");
        }
    }

    /**
     * 点赞->取消点赞
     * wumaoxing
     * 2020-10-26 17:06
     */
    @PostMapping("deleteLikeMediaBusiness")
    public AppResponse deleteLikeMediaBusiness(LikeMediaBusinessInfo likeMediaBusinessInfo) {
        try {
            return likeMediaBusinessService.deleteLikeMediaBusiness(likeMediaBusinessInfo);
        } catch (Exception e) {
            logger.error("点赞->取消点赞成功", e);
            throw new ScServerException("点赞->取消点赞错误，请重试");
        }
    }
}
