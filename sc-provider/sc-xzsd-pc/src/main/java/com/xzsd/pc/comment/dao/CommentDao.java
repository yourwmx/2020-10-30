package com.xzsd.pc.comment.dao;

import com.xzsd.pc.comment.entity.CommentInfo;

import java.util.List;

public interface CommentDao {
    /**
     * 查询媒体评价分页列表
     * wumaoxing
     * 2020-10-27 23:06
     */
    List<CommentInfo> listComments(CommentInfo commentInfo);
    /**
     * 对媒体进行评价
     * wumaoxing
     * 2020-10-27 23:07
     */
    int actionMediaComment(CommentInfo commentInfo);
}
