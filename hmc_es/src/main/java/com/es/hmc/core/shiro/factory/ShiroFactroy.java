package com.es.hmc.core.shiro.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.es.hmc.core.shiro.ShiroUser;
import com.es.hmc.domain.User;
import com.es.hmc.utils.SpringContextHolder;


@Service
@DependsOn("springContextHolder")
public class ShiroFactroy implements IShiro {
 

    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }



    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setAccount(user.getAccount());// 账号
        shiroUser.setDeptId(user.getDeptid());    // 部门id
        shiroUser.setDeptName("产品部");// 部门名称
      //  shiroUser.setDeptName(LogicConstantFactory.me().getDeptName(user.getDeptid()));// 部门名称
        shiroUser.setName(user.getName());        // 用户名称

       /* Integer[] roleArray = Convert.toIntArray(user.getRoleid());// 角色集合
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(LogicConstantFactory.me().getSingleRoleName(roleId));
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);
        	*/
        return shiroUser;
    }

   

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }



	@Override
	public User user(String account) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<String> findPermissionsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String findRoleNameByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
