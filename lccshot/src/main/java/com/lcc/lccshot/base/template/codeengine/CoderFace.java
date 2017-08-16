package com.lcc.lccshot.base.template.codeengine;

import com.lcc.lccshot.base.template.config.CodeConfig;

public interface CoderFace {
	/**
	 * 编辑界面html
	 */
     void createPageEditHtml();
     /**
 	 * 新增界面html
 	 */
     void createPageAddHtml();
     /**
      * 初始界面html
      */
     void createPageHtml();
     /**
      * 编辑界面js
      */
     void createPageInfoJs();
     /**
      * 初始界面js
      */
     void createPageJs();
     /**
      * 控制器类
      */
     void createController();
     /**
      * 服务类
      */
     void createServiceImpl();
     /**
      * 服务类
      */
     void createIService();
     /**
      * dao层类
      */
     void createDao();
}
