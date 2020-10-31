package com.xzsd.pc.comment.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.comment.entity.CommentInfo;
import com.xzsd.pc.comment.service.CommentService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private CommentService commentService;

    /**
     * 对媒体进行评价
     * wumaoxing
     * 2020-10-27 22:52
     */
    @PostMapping(value = "actionMediaComment")
    public AppResponse actionMediaComment(CommentInfo commentInfo) {
        try {
            commentInfo.setCreateBy(commentInfo.getUserId());
            return commentService.actionMediaComment(commentInfo);
        } catch (Exception e) {
            logger.error("对媒体进行评价异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询媒体评价分页列表
     * wumaoxing
     * 2020-10-27 22:53
     */
    @RequestMapping(value = "listComments")
    public AppResponse listComments(CommentInfo commentInfo) {
        try {
            return commentService.listComments(commentInfo);
        } catch (Exception e) {
            logger.error("查询媒体评价分页异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
