package com.es.hmc.constant.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.es.hmc.constant.cache.Cache;
import com.es.hmc.constant.cache.CacheKey;
import com.es.hmc.constant.state.ManagerStatus;
import com.es.hmc.constant.state.MenuStatus;
import com.es.hmc.constant.state.Sex;
import com.es.hmc.domain.Dict;
import com.es.hmc.domain.User;
import com.es.hmc.utils.Convert;
import com.es.hmc.utils.SpringContextHolder;
import com.es.hmc.utils.StrKit;
import com.es.hmc.utils.ToolUtil;

/**
 * 常量的生产工厂
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:55:21
 */
@Component
@DependsOn("springContextHolder")
public class LogicConstantFactory implements IConstantFactory {


    public static IConstantFactory me() {
        return SpringContextHolder.getBean(IConstantFactory.class);
    }

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    public String getUserNameById(Integer userId) {
       // User user = userMapper.findById(userId);
    	 User user = new User();
        if (user != null) {
            return user.getName();
        } else {
            return "--";
        }
    }

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    public String getUserAccountById(Integer userId) {
        //User user = userMapper.findById(userId);
    	User user = new User();
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }




    /**
     * 获取性别名称
     */
    public String getSexName(Integer sex) {
        return Sex.valueOf(sex);
    }

    /**
     * 获取用户登录状态
     */
    public String getStatusName(Integer status) {
        return ManagerStatus.valueOf(status);
    }

    /**
     * 获取菜单状态
     */
    public String getMenuStatusName(Integer status) {
        return MenuStatus.valueOf(status);
    }

    /**
     * 查询字典
     */
    public List<Dict> findInDict(Integer id) {
        if (ToolUtil.isEmpty(id)) {
            return null;
        } else {
            EntityWrapper<Dict> wrapper = new EntityWrapper<Dict>();
           // List<Dict> dicts = dictMapper.selectList(wrapper.eq("pid", id));
            //List<Dict> dicts =  dictMapper.findByPid(id);
            List<Dict> dicts =   new ArrayList<Dict>();
            if (dicts == null || dicts.size() == 0) {
                return null;
            } else {
                return dicts;
            }
        }
    }

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    public String getCacheObject(String para) {
        return "";
    }

	@Override
	public String getRoleName(String roleIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSingleRoleName(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSingleRoleTip(Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeptName(Integer deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMenuNames(String menuIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMenuName(Integer menuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMenuNameByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDictName(Integer dictId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoticeTitle(Integer dictId) {
		// TODO Auto-generated method stub
		return null;
	}

}
