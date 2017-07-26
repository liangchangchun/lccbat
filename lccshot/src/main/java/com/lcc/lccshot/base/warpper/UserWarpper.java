package com.lcc.lccshot.base.warpper;

import java.util.List;
import java.util.Map;

import com.lcc.lccshot.base.BaseControllerWarpper;
import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.domain.User;

/**
 * 用户管理的包装类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:47:03
 */
public class UserWarpper extends BaseControllerWarpper {
	
    public UserWarpper(Object obj) {
		super(obj);
	}

    public UserWarpper(Object obj, Class type) {
		super(obj, type);
	}

	@Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sexName", LogicConstantFactory.me().getSexName((Integer) map.get("sex")));
        map.put("roleName", LogicConstantFactory.me().getRoleName((String) map.get("roleid")));
        map.put("deptName", LogicConstantFactory.me().getDeptName((Integer) map.get("deptid")));
        map.put("statusName", LogicConstantFactory.me().getStatusName((Integer) map.get("status")));
    }

}
