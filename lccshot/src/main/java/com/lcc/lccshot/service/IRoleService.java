package com.lcc.lccshot.service;

import java.util.List;

import com.lcc.lccshot.domain.Role;
import com.lcc.lccshot.domain.view.ZTreeView;
import com.lcc.lccshot.domain.vo.ZTreeNode;

/**
 * 角色相关业务
 *
 * @author fengshuonan
 * @Date 2017年1月10日 下午9:11:57
 */
public interface IRoleService {

    /**
     * 设置某个角色的权限
     *
     * @param roleId 角色id
     * @param ids    权限的id
     * @date 2017年2月13日 下午8:26:53
     */
    void setAuthority(Integer roleId, String ids);

    /**
     * 删除角色
     *
     * @author stylefeng
     * @Date 2017/5/5 22:24
     */
    void delRoleById(Integer roleId);
    /**
     * 根据单个字段查询
     * @param column
     * @param value
     * @return
     */
    List<Role> findAll(final String column,final String value);
    
    List<ZTreeNode> roleTreeList();
    
    List<ZTreeNode> roleTreeListByRoleId(String[] roleIds);
}
