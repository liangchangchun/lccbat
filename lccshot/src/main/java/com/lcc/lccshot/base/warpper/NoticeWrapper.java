package com.lcc.lccshot.base.warpper;

import java.util.Map;

import com.lcc.lccshot.base.BaseControllerWarpper;
import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;

/**
 * 部门列表的包装
 *
 * @author fengshuonan
 * @date 2017年4月25日 18:10:31
 */
public class NoticeWrapper extends BaseControllerWarpper {


    public NoticeWrapper(Object obj, Class type) {
		super(obj, type);
	}

	@Override
    public void warpTheMap(Map<String, Object> map) {
        Integer creater = (Integer) map.get("creater");
        map.put("createrName", LogicConstantFactory.me().getUserNameById(creater));
    }

}
