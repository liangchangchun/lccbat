package com.lcc.lccshot.core.beetl;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import com.lcc.lccshot.core.shiro.ShiroExt;
import com.lcc.lccshot.utils.ToolUtil;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration{
	@Override
	public void initOther() {

		groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
		groupTemplate.registerFunctionPackage("tool", new ToolUtil());

	}
}
