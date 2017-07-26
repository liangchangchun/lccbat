package com.lcc.lccshot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lcc.lccshot.domain.view.MenuView;
import com.lcc.lccshot.domain.view.ZTreeView;
import com.lcc.lccshot.domain.vo.MenuNode;
import com.lcc.lccshot.domain.vo.ZTreeNode;
import com.lcc.lccshot.repository.MenuRepository;
import com.lcc.lccshot.repository.RelationRepository;
import com.lcc.lccshot.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	MenuRepository menuDao;
	
	@Autowired
	RelationRepository relationDao;
	
    @Override
    public void delMenu(Integer menuId) {

        //删除菜单
        this.menuDao.delete(menuId);

        //删除关联的relation
        this.relationDao.deleteByMenuId(menuId);
    }
    
    
	
	@Override
	public List<MenuNode> getMenusByRoleIds(List<Integer> roleList) {
		List<MenuNode> menuNode =Lists.newArrayList();
		List<MenuView> views = menuDao.findViewByRoleIds(roleList);
		for (MenuView view : views) {
			MenuNode node =new MenuNode(view);
			menuNode.add(node);
		}
		for (MenuNode node1 : menuNode) {
			List<MenuNode> childNodes=null;
			for (MenuNode node2 : menuNode){
				if (node1.getId().equals(node2.getParentId())){
				    childNodes =Lists.newArrayList();
					childNodes.add(node2);
				}
			}
			node1.setChildren(childNodes);
		}
		
		return menuNode;
	}
	
	@Override
	public List<ZTreeNode> tree() {
		List<ZTreeNode> ztreeNode =Lists.newArrayList();
		List<ZTreeView> views = menuDao.tree();
		for (ZTreeView view : views) {
			ZTreeNode node =new ZTreeNode(view);
			ztreeNode.add(node);
		}
		return ztreeNode;
	}



	@Override
	public List<ZTreeNode> menuTreeList() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ZTreeNode> menuTreeListByMenuIds(List<Integer> menuIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
