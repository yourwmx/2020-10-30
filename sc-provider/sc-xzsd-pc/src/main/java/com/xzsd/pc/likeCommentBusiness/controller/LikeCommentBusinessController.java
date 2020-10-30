package com.xzsd.pc.likeCommentBusiness.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.likeCommentBusiness.entity.LikeCommentBusinessInfo;
import com.xzsd.pc.likeCommentBusiness.service.LikeCommentBusinessService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("likeCommentBusiness")
public class LikeCommentBusinessController {

    private static final Logger logger = LoggerFactory.getLogger(LikeCommentBusinessController.class);

    @Resource
    private LikeCommentBusinessService likeCommentBusinessService;

    /**
     * 获取点赞评论业务编号
     * wumaoxing
     * 2020-10-30 11:19
     */
    @RequestMapping("queryLikeCommentBusinessId")
    public AppResponse queryLikeCommentBusinessId(String commentId) {
        try {
            return likeCommentBusinessService.queryLikeCommentBusinessId(commentId);
        } catch (Exception e) {
            logger.error("获取点赞评论业务编号成功", e);
            throw new ScServerException("查询错误，请重试");
        }
    }

    /**
     * 未点赞->点赞
     * wumaoxing
     * 2020-10-30 11:20
     */
    @PostMapping("addLikeCommentBusiness")
    public AppResponse addLikeCommentBusiness(LikeCommentBusinessInfo likeCommentBusinessInfo) {
        try {
            return likeCommentBusinessService.addLikeCommentBusiness(likeCommentBusinessInfo);
        } catch (Exception e) {
            logger.error("未点赞->点赞成功", e);
            throw new ScServerException("未点赞->点赞错误，请重试");
        }
    }

    /**
     * 点赞->取消点赞
     * wumaoxing
     * 2020-10-30 11:22
     */
    @PostMapping("deleteLikeCommentBusiness")
    public AppResponse deleteLikeCommentBusiness(LikeCommentBusinessInfo likeCommentBusinessInfo) {
        try {
            return likeCommentBusinessService.deleteLikeCommentBusiness(likeCommentBusinessInfo);
        } catch (Exception e) {
            logger.error("点赞->取消点赞成功", e);
            throw new ScServerException("点赞->取消点赞错误，请重试");
        }
    }
}
