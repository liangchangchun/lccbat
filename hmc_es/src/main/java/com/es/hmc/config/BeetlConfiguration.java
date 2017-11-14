package com.es.hmc.config;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import com.es.hmc.core.shiro.ShiroExt;
import com.es.hmc.utils.ToolUtil;


public class BeetlConfiguration extends BeetlGroupUtilConfiguration{
	@Override
	public void initOther() {

		groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
		groupTemplate.registerFunctionPackage("tool", new ToolUtil());

	}
}
