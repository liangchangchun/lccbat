package com.lcc.lccshot.base.warpper;

import java.util.Map;

import com.lcc.lccshot.base.BaseControllerWarpper;
import com.lcc.lccshot.enums.ProjectType;

public class FastProjectWarpper extends BaseControllerWarpper {

	public FastProjectWarpper(Object obj, Class type) {
		super(obj, type);
	}

	@Override
	protected void warpTheMap(Map<String, Object> map) {
		 map.put("projectTypeName", ProjectType.valueOf((Integer) map.get("projectType")));
	}

}
