package com.neusoft.webauth.menu.service;

import com.neusoft.webauth.base.entity.Tree;
import com.neusoft.webauth.menu.dao.MenuDao;
import com.neusoft.webauth.menu.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 部门：南京软件研发中心
     * 功能：查询全部菜单
     * 描述：查询全部菜单，如果角色代码不为空，则查询角色已授权的菜单
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    public Map<String,Object> listMenus(String rootId, String role) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 查询全部菜单
        List<Menu> allMenus = menuDao.listMenus(role);
        Tree rootTree = new Tree();
        // 格式化菜单成树结构
        initTree(rootTree, allMenus, rootId);
        map.put("rootTree",rootTree.getChildren());
        return map;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：初始化菜单树
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    private void initTree(Tree rootTree, List<Menu> allMenus, String selfCode){
        Iterator<Menu> menuIterator = allMenus.iterator();
        while(menuIterator.hasNext()){
            Menu temp = menuIterator.next();
            //初始化自身节点
            if(temp.getMenuId().equals(selfCode)){
                menuToTree(temp,rootTree);
            }else if(temp.getLastLevelId().equals(selfCode)){
                //初始化子节点
                Tree children = new Tree();
                menuToTree(temp,children);
                rootTree.getChildren().add(children);
                //递归
                initTree(children,allMenus,temp.getMenuId());
            }
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：将菜单格式化成树
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/28
     */
    private void menuToTree(Menu menu, Tree tree){
        tree.setId(menu.getMenuId());
        tree.setIndex(menu.getMenuRoute());
        tree.setPid(menu.getLastLevelId());
        tree.setLabel(menu.getMenuName());
        tree.setAttributes(menu);
    }

}
