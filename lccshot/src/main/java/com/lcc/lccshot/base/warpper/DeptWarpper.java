package com.lcc.lccshot.base.warpper;

import java.util.Map;

import com.lcc.lccshot.base.BaseControllerWarpper;
import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.utils.ToolUtil;

/**
 * 部门列表的包装
 *
 * @author fengshuonan
 * @date 2017年4月25日 18:10:31
 */
public class DeptWarpper extends BaseControllerWarpper {

    public DeptWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        Integer pid = (Integer) map.get("pid");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", LogicConstantFactory.me().getDeptName(pid));
        }
    }

}
