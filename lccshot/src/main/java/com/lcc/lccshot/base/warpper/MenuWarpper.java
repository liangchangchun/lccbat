package com.lcc.lccshot.base.warpper;

import java.util.List;
import java.util.Map;

import com.lcc.lccshot.base.BaseControllerWarpper;
import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.core.constant.state.IsMenu;
import com.lcc.lccshot.domain.Menu;

/**
 * 菜单列表的包装类
 *
 * @author fengshuonan
 * @date 2017年2月19日15:07:29
 */
public class MenuWarpper extends BaseControllerWarpper {

  

    public MenuWarpper(Object obj, Class type) {
		super(obj, type);
	}

	@Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("statusName", LogicConstantFactory.me().getMenuStatusName((Integer) map.get("status")));
        map.put("isMenuName", IsMenu.valueOf((Integer) map.get("ismenu")));
    }

}
