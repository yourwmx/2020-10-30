package com.neusoft.webauth.menu.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.webauth.base.constant.GlobalConstant;
import com.neusoft.webauth.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * 部门：南京软件研发中心
     * 功能：获取菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    @RequestMapping(value = "listMenus")
    public AppResponse listMenus(String role) {
        try {
            Map<String,Object> map = menuService.listMenus(GlobalConstant.MENU_ROOT, role);
            return AppResponse.success("查询成功", map);
        } catch (Exception e) {
            logger.error("菜单获取异常", e);
            throw new ScServerException("菜单获取失败，请重试");
        }
    }


}
