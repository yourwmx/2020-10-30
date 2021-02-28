package com.neusoft.webauth.user.controller;


import com.neusoft.core.exception.ScServerException;
import com.neusoft.webauth.user.entity.UserInfo;
import com.neusoft.webauth.user.service.UserService;
import com.neusoft.webauth.utils.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @ClassName UserController
 * @Description 用户管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * wumaoxing
     * 2020-10-20 22:46
     */
    @RequestMapping("login")
    public AppResponse login(String code) {
        try {
            AppResponse appResponse = userService.login(code);
            return appResponse;
        } catch (Exception e) {
            logger.error("查询openid失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 用户注册
     * wumaoxing
     * 2020-08-20 19:58
     */
    @PostMapping(value = "addUser")
    public AppResponse addUser(UserInfo userInfo){
        try {
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户注册失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 个人信息查询
     * wumaoxing
     * 2020-08-20 20:51
     */
    @RequestMapping(value = "findUserById")
    public AppResponse findUserById(String userId) {
        try {
            return userService.findUserById(userId);
        } catch (Exception e) {
            logger.error("查询个人信息异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     * wumaoxing
     * 2020-10-24 15:40
     */
    @PostMapping(value = "updateUserById")
    public AppResponse updateUserById(UserInfo userInfo){
        try {
            AppResponse appResponse = userService.updateUserById(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改用户失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 用户列表
     * wumaoxing
     * 2021-02-28 14:04
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
