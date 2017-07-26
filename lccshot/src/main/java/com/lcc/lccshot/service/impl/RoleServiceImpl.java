package com.lcc.lccshot.service.impl;

import com.lcc.lccshot.utils.Convert;
import com.lcc.lccshot.service.IRoleService;
import com.google.common.collect.Lists;
import com.lcc.lccshot.domain.Relation;
import com.lcc.lccshot.domain.Role;
import com.lcc.lccshot.domain.view.MenuView;
import com.lcc.lccshot.domain.view.ZTreeView;
import com.lcc.lccshot.domain.vo.MenuNode;
import com.lcc.lccshot.domain.vo.ZTreeNode;
import com.lcc.lccshot.repository.RelationRepository;
import com.lcc.lccshot.repository.RoleRepository;

import org.assertj.core.util.Strings;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class RoleServiceImpl implements IRoleService {


    @Resource
    RoleRepository roleDao;

    @Resource
    RelationRepository relationDao;
    
    @Override
   public List<Role> findAll(final String column,final String value){
    	Specification<Role> specification = new Specification<Role>() {  
            @Override  
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {  
            	if(!Strings.isNullOrEmpty(value)){
                Path col = root.get(column);  
                Predicate predicate = cb.and(cb.like(col, "%"+value+"%"));  
                return predicate; 
            	}
                return null;
            }  
        };  
        
        return roleDao.findAll(specification);
    }

    @Override
    @Transactional(readOnly = false)
    public void setAuthority(Integer roleId, String ids) {

        // 删除该角色所有的权限
        this.roleDao.deleteById(roleId);

        // 添加新的权限
        for (Integer id : Convert.toIntArray(ids)) {
            Relation relation = new Relation();
            relation.setRoleid(roleId);
            relation.setMenuid(id);
            this.relationDao.save(relation);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void delRoleById(Integer roleId) {
        //删除角色
        this.roleDao.deleteById(roleId);

        // 删除该角色所有的权限
        this.relationDao.deleteByRoleId(roleId);
    }

	@Override
	public List<ZTreeNode> roleTreeList() {
		List<ZTreeNode> zTreeNode =Lists.newArrayList();
		List<ZTreeView> views = roleDao.roleTreeList();
		for (ZTreeView view : views) {
			ZTreeNode node =new ZTreeNode(view);
			zTreeNode.add(node);
		}
		return zTreeNode;
	}
	
	@Override
	public List<ZTreeNode> roleTreeListByRoleId(String[] roleIds){
		List<ZTreeNode> zTreeNode =Lists.newArrayList();
		List<ZTreeView> views = roleDao.roleTreeListByRoleId(roleIds);
		for (ZTreeView view : views) {
			ZTreeNode node =new ZTreeNode(view);
			zTreeNode.add(node);
		}
		return zTreeNode;
	}
    

}
