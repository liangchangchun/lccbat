package com.lcc.lccshot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lcc.lccshot.core.map2sql.BaseServiceTemplate;
import com.lcc.lccshot.core.map2sql.Conditions;
import com.lcc.lccshot.core.map2sql.Where;
import com.lcc.lccshot.domain.Menu;
import com.lcc.lccshot.domain.User;
import com.lcc.lccshot.domain.view.MenuView;
import com.lcc.lccshot.domain.view.ZTreeView;
import com.lcc.lccshot.domain.vo.MenuNode;
import com.lcc.lccshot.domain.vo.ZTreeNode;
import com.lcc.lccshot.repository.MenuRepository;
import com.lcc.lccshot.repository.RelationRepository;
import com.lcc.lccshot.repository.UserRepository;
import com.lcc.lccshot.service.IMenuService;

@Service
public class MenuServiceImpl extends BaseServiceTemplate<MenuRepository,Menu> implements IMenuService{

	
	@Autowired
	RelationRepository relationDao;
	
    @Override
    public void delMenu(Integer menuId) {

        //删除菜单
        this.repository.delete(menuId);

        //删除关联的relation
        this.relationDao.deleteByMenuId(menuId);
    }
    
    
	
	@Override
	public List<MenuNode> getMenusByRoleIds(List<Integer> roleList) {
		List<MenuNode> menuNode =Lists.newArrayList();
		List<MenuView> views = repository.findViewByRoleIds(roleList);
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
		List<ZTreeView> views = repository.tree();
		for (ZTreeView view : views) {
			ZTreeNode node =new ZTreeNode(view);
			ztreeNode.add(node);
		}
		return ztreeNode;
	}



	@Override
	public List<ZTreeNode> menuTreeList() {
		List<ZTreeNode> ztreeNode =Lists.newArrayList();
		List<ZTreeView> views = repository.menuTreeList();
		for (ZTreeView view : views) {
			ZTreeNode node =new ZTreeNode(view);
			ztreeNode.add(node);
		}
				
		return ztreeNode;
	}

	@Override
	public List<Menu> selectMenus(String menuName,String level){
		Where where = Where.create()
				//.add(Conditions.create().and().eq("status", 1))
				.add(Conditions.create().or().like("name", menuName))
				.add(Conditions.create().or().like("code", menuName))
				.add(Conditions.create().and().eq("levels", level));
		this.initWhere(where);
		return this.findAll();
	}


	@Override
	public List<ZTreeNode> menuTreeListByMenuIds(List<Integer> menuIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
