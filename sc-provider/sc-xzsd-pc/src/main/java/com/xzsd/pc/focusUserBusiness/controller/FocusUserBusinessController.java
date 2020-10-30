package com.xzsd.pc.focusUserBusiness.controller;

import com.neusoft.core.exception.ScServerException;
import com.xzsd.pc.focusUserBusiness.entity.FocusUserBusinessInfo;
import com.xzsd.pc.focusUserBusiness.service.FocusUserBusinessService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("focusUserBusiness")
public class FocusUserBusinessController {

    private static final Logger logger = LoggerFactory.getLogger(FocusUserBusinessController.class);

    @Resource
    private FocusUserBusinessService focusUserBusinessService;

    /**
     * 获取关注用户业务编号
     * wumaoxing
     * 2020-10-27 15:37
     */
    @RequestMapping("queryFocusUserBusinessId")
    public AppResponse queryFocusUserBusinessId(String userId) {
        try {
            return focusUserBusinessService.queryFocusUserBusinessId(userId);
        } catch (Exception e) {
            logger.error("获取关注用户业务编号成功", e);
            throw new ScServerException("查询错误，请重试");
        }
    }

    /**
     * 未关注->关注
     * wumaoxing
     * 2020-10-27 15:47
     */
    @PostMapping("addFocusUserBusiness")
    public AppResponse addFocusUserBusiness(FocusUserBusinessInfo focusUserBusinessInfo) {
        try {
            return focusUserBusinessService.addFocusUserBusiness(focusUserBusinessInfo);
        } catch (Exception e) {
            logger.error("未关注->关注成功", e);
            throw new ScServerException("未关注->关注错误，请重试");
        }
    }

    /**
     * 关注->取消关注
     * wumaoxing
     * 2020-10-27 16:57
     */
    @PostMapping("deleteFocusUserBusiness")
    public AppResponse deleteFocusUserBusiness(FocusUserBusinessInfo focusUserBusinessInfo) {
        try {
            return focusUserBusinessService.deleteFocusUserBusiness(focusUserBusinessInfo);
        } catch (Exception e) {
            logger.error("关注->取消关注成功", e);
            throw new ScServerException("关注->取消关注错误，请重试");
        }
    }
}
