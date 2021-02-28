package com.neusoft.webauth.user.dao;

import com.neusoft.webauth.user.entity.UserInfo;

import java.util.List;

public interface UserDao {
    /**
     * 校验账号是否存在
     * wumaoxing
     * 2020-08-20 20:29
     */
    int countUser(UserInfo userInfo);
    /**
     * 校验openid是否存在
     * wumaoxing
     * 2020-10-24 18:10
     */
    int countUserOpenid(UserInfo userInfo);
    /**
     * 用户注册
     * wumaoxing
     * 2020-08-20 20:27
     */
    int addUser(UserInfo userInfo);
    /**
     * 个人信息查询
     * wumaoxing
     * 2020-08-20 20:53
     */
    UserInfo findUserById(String userId);
    /**
     * 修改用户
     * wumaoxing
     * 2020-10-24 15:47
     */
    int updateUserById(UserInfo userInfo);
    /**
     * 用户列表
     * wumaoxing
     * 2021-02-28 14:08
     */
    List<UserInfo> listUsers(UserInfo userInfo);
}
