package com.lcc.lccshot.base.warpper;

import java.util.List;
import java.util.Map;

import com.lcc.lccshot.base.BaseControllerWarpper;
import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.domain.Role;

/**
 * 角色列表的包装类
 *
 * @author fengshuonan
 * @date 2017年2月19日10:59:02
 */
public class RoleWarpper extends BaseControllerWarpper {

	  public RoleWarpper(Object obj) {
			super(obj);
		}

    public RoleWarpper(Object obj, Class type) {
		super(obj, type);
	}

	@Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("pName", LogicConstantFactory.me().getSingleRoleName((Integer) map.get("pid")));
        map.put("deptName", LogicConstantFactory.me().getDeptName((Integer) map.get("deptid")));
    }
    
}
