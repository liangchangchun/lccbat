package com.lcc.lccshot.service;

import java.util.List;

import com.lcc.lccshot.domain.Menu;
import com.lcc.lccshot.domain.vo.MenuNode;
import com.lcc.lccshot.domain.vo.ZTreeNode;

/**
 * 菜单服务
 *
 * @author fengshuonan
 * @date 2017-05-05 22:19
 */
public interface IMenuService {

	List<MenuNode> getMenusByRoleIds(List<Integer> roleList);
	
	List<ZTreeNode> menuTreeList();
	
	List<ZTreeNode> menuTreeListByMenuIds(List<Integer> menuIds);
	
	List<ZTreeNode> tree();
	
	List<Menu> selectMenus(String menuName,String level);
	 /**
    * 删除菜单
    *
    * @author stylefeng
    * @Date 2017/5/5 22:20
    */
   void delMenu(Integer menuId);
    

}
