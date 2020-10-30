package com.xzsd.pc.comment.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.comment.dao.CommentDao;
import com.xzsd.pc.comment.entity.CommentInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentDao commentDao;

    /**
     * 对媒体进行评价
     * wumaoxing
     * 2020-10-27 23:05
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse actionMediaComment(CommentInfo commentInfo){
        commentInfo.setCommentId(StringUtil.getCommonCode(2));
        //加入评价列表
        int count = commentDao.actionMediaComment(commentInfo);
        if (count == 0) {
            return AppResponse.bizError("加入评价列表失败，请重试！");
        }
        return AppResponse.success("评价成功！");
    }

    /**
     * 查询媒体评价分页列表
     * wumaoxing
     * 2020-10-27 23:04
     */
    public AppResponse listComments(CommentInfo commentInfo) {
        PageHelper.startPage(commentInfo.getPageNum(), commentInfo.getPageSize());
        List<CommentInfo> commentInfoList = commentDao.listComments(commentInfo);
        PageInfo<CommentInfo> pageData = new PageInfo<CommentInfo>(commentInfoList);
        return AppResponse.success("查询成功！",pageData);
    }
}
