/*
MySQL Backup
Source Server Version: 5.7.19
Source Database: test
Date: 2017/8/14 18:23:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
--  Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
--  Table structure for `fast_project`
-- ----------------------------
DROP TABLE IF EXISTS `fast_project`;
CREATE TABLE `fast_project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `fast_table`
-- ----------------------------
DROP TABLE IF EXISTS `fast_table`;
CREATE TABLE `fast_table` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `column_type` varchar(255) DEFAULT NULL,
  `columns` varchar(255) DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `girl`
-- ----------------------------
DROP TABLE IF EXISTS `girl`;
CREATE TABLE `girl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `cup_size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `login_log`
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
--  Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
--  Table structure for `operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=487 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
--  Table structure for `relation`
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3681 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `dept` VALUES ('24','1','0','[0],','总公司','总公司','',NULL), ('25','2','24','[0],[24],','开发部','开发部','',NULL), ('26','3','24','[0],[24],','运营部','运营部','',NULL), ('27','4','24','[0],[24],','战略部','战略部','',NULL);
INSERT INTO `dict` VALUES ('16','0','0','状态',NULL), ('17','1','16','启用',NULL), ('18','2','16','禁用',NULL), ('29','0','0','性别',NULL), ('30','1','29','男',NULL), ('31','2','29','女',NULL), ('35','0','0','账号状态',NULL), ('36','1','35','启用',NULL), ('37','2','35','冻结',NULL), ('38','3','35','已删除',NULL);
INSERT INTO `login_log` VALUES ('126','退出日志','1','2017-06-04 10:21:55','成功',NULL,'127.0.0.1'), ('127','登录日志','1','2017-06-04 10:21:59','成功',NULL,'127.0.0.1'), ('128','退出日志','1','2017-06-04 10:22:59','成功',NULL,'127.0.0.1'), ('129','登录日志','1','2017-06-04 10:23:01','成功',NULL,'127.0.0.1'), ('130','登录失败日志',NULL,'2017-08-14 17:12:02','成功','账号:admin,账号密码错误','0:0:0:0:0:0:0:1'), ('131','登录日志','1','2017-08-14 17:12:20','成功',NULL,'0:0:0:0:0:0:0:1'), ('132','退出日志','1','2017-08-14 17:52:17','成功',NULL,'0:0:0:0:0:0:0:1'), ('133','登录日志','1','2017-08-14 17:52:22','成功',NULL,'0:0:0:0:0:0:0:1'), ('134','登录日志','1','2017-08-14 17:53:20','成功',NULL,'0:0:0:0:0:0:0:1'), ('135','退出日志','1','2017-08-14 18:00:12','成功',NULL,'0:0:0:0:0:0:0:1'), ('136','登录日志','1','2017-08-14 18:00:17','成功',NULL,'0:0:0:0:0:0:0:1'), ('137','退出日志','1','2017-08-14 18:05:03','成功',NULL,'0:0:0:0:0:0:0:1'), ('138','登录日志','1','2017-08-14 18:05:09','成功',NULL,'0:0:0:0:0:0:0:1'), ('139','退出日志','1','2017-08-14 18:06:02','成功',NULL,'0:0:0:0:0:0:0:1'), ('140','登录日志','1','2017-08-14 18:06:07','成功',NULL,'0:0:0:0:0:0:0:1'), ('141','退出日志','1','2017-08-14 18:08:23','成功',NULL,'0:0:0:0:0:0:0:1'), ('142','登录日志','1','2017-08-14 18:08:28','成功',NULL,'0:0:0:0:0:0:0:1');
INSERT INTO `menu` VALUES ('105','system','0','[0],','系统管理','fa-user','','3','1','1',NULL,'1','1'), ('106','mgr','system','[0],[system],','用户管理','','/mgr','1','2','1',NULL,'1','0'), ('107','mgr_add','mgr','[0],[system],[mgr],','添加用户',NULL,'/mgr/add','1','3','0',NULL,'1','0'), ('108','mgr_edit','mgr','[0],[system],[mgr],','修改用户',NULL,'/mgr/edit','2','3','0',NULL,'1','0'), ('109','mgr_delete','mgr','[0],[system],[mgr],','删除用户',NULL,'/mgr/delete','3','3','0',NULL,'1','0'), ('110','mgr_reset','mgr','[0],[system],[mgr],','重置密码',NULL,'/mgr/reset','4','3','0',NULL,'1','0'), ('111','mgr_freeze','mgr','[0],[system],[mgr],','冻结用户',NULL,'/mgr/freeze','5','3','0',NULL,'1','0'), ('112','mgr_unfreeze','mgr','[0],[system],[mgr],','解除冻结用户',NULL,'/mgr/unfreeze','6','3','0',NULL,'1','0'), ('113','mgr_setRole','mgr','[0],[system],[mgr],','分配角色',NULL,'/mgr/setRole','7','3','0',NULL,'1','0'), ('114','role','system','[0],[system],','角色管理',NULL,'/role','2','2','1',NULL,'1','0'), ('115','role_add','role','[0],[system],[role],','添加角色',NULL,'/role/add','1','3','0',NULL,'1','0'), ('116','role_edit','role','[0],[system],[role],','修改角色',NULL,'/role/edit','2','3','0',NULL,'1','0'), ('117','role_remove','role','[0],[system],[role],','删除角色',NULL,'/role/remove','3','3','0',NULL,'1','0'), ('118','role_setAuthority','role','[0],[system],[role],','配置权限',NULL,'/role/setAuthority','4','3','0',NULL,'1','0'), ('119','menu','system','[0],[system],','菜单管理',NULL,'/menu','4','2','1',NULL,'1','0'), ('120','menu_add','menu','[0],[system],[menu],','添加菜单',NULL,'/menu/add','1','3','0',NULL,'1','0'), ('121','menu_edit','menu','[0],[system],[menu],','修改菜单',NULL,'/menu/edit','2','3','0',NULL,'1','0'), ('122','menu_remove','menu','[0],[system],[menu],','删除菜单',NULL,'/menu/remove','3','3','0',NULL,'1','0'), ('128','log','system','[0],[system],','业务日志',NULL,'/log','6','2','1',NULL,'1','0'), ('130','druid','system','[0],[system],','监控管理',NULL,'/druid','7','2','1',NULL,'1',NULL), ('131','dept','system','[0],[system],','部门管理',NULL,'/dept','3','2','1',NULL,'1',NULL), ('132','dict','system','[0],[system],','字典管理',NULL,'/dict','4','2','1',NULL,'1',NULL), ('133','loginLog','system','[0],[system],','登录日志',NULL,'/loginLog','6','2','1',NULL,'1',NULL), ('134','log_clean','log','[0],[system],[log],','清空日志',NULL,'/log/delLog','3','3','0',NULL,'1',NULL), ('135','dept_add','dept','[0],[system],[dept],','添加部门',NULL,'/dept/add','1','3','0',NULL,'1',NULL), ('136','dept_update','dept','[0],[system],[dept],','修改部门',NULL,'/dept/update','1','3','0',NULL,'1',NULL), ('137','dept_delete','dept','[0],[system],[dept],','删除部门',NULL,'/dept/delete','1','3','0',NULL,'1',NULL), ('138','dict_add','dict','[0],[system],[dict],','添加字典',NULL,'/dict/add','1','3','0',NULL,'1',NULL), ('139','dict_update','dict','[0],[system],[dict],','修改字典',NULL,'/dict/update','1','3','0',NULL,'1',NULL), ('140','dict_delete','dict','[0],[system],[dict],','删除字典',NULL,'/dict/delete','1','3','0',NULL,'1',NULL), ('141','notice','system','[0],[system],','通知管理',NULL,'/notice','9','2','1',NULL,'1',NULL), ('142','notice_add','notice','[0],[system],[notice],','添加通知',NULL,'/notice/add','1','3','0',NULL,'1',NULL), ('143','notice_update','notice','[0],[system],[notice],','修改通知',NULL,'/notice/update','2','3','0',NULL,'1',NULL), ('144','notice_delete','notice','[0],[system],[notice],','删除通知',NULL,'/notice/delete','3','3','0',NULL,'1',NULL), ('145','hello','0','[0],','通知','fa-rocket','/notice/hello','1','1','1',NULL,'1',NULL), ('148','code','system','[0],[system],','代码生成','fa-user','/code','10','2','1',NULL,'1',NULL), ('149','api_mgr','0','[0],','接口文档','fa-leaf','/swagger-ui.html','2','1','1',NULL,'1',NULL), ('150','to_menu_edit','menu','[0],[system],[menu],','菜单编辑跳转','','/menu/menu_edit','4','3','0',NULL,'1',NULL), ('151','menu_list','menu','[0],[system],[menu],','菜单列表','','/menu/list','5','3','0',NULL,'1',NULL), ('152','to_dept_update','dept','[0],[system],[dept],','修改部门跳转','','/dept/dept_update','4','3','0',NULL,'1',NULL), ('153','dept_list','dept','[0],[system],[dept],','部门列表','','/dept/list','5','3','0',NULL,'1',NULL), ('154','dept_detail','dept','[0],[system],[dept],','部门详情','','/dept/detail','6','3','0',NULL,'1',NULL), ('155','to_dict_edit','dict','[0],[system],[dict],','修改菜单跳转','','/dict/dict_edit','4','3','0',NULL,'1',NULL), ('156','dict_list','dict','[0],[system],[dict],','字典列表','','/dict/list','5','3','0',NULL,'1',NULL), ('157','dict_detail','dict','[0],[system],[dict],','字典详情','','/dict/detail','6','3','0',NULL,'1',NULL), ('158','log_list','log','[0],[system],[log],','日志列表','','/log/list','2','3','0',NULL,'1',NULL), ('159','log_detail','log','[0],[system],[log],','日志详情','','/log/detail','3','3','0',NULL,'1',NULL), ('160','del_login_log','loginLog','[0],[system],[loginLog],','清空登录日志','','/loginLog/delLoginLog','1','3','0',NULL,'1',NULL), ('161','login_log_list','loginLog','[0],[system],[loginLog],','登录日志列表','','/loginLog/list','2','3','0',NULL,'1',NULL), ('162','to_role_edit','role','[0],[system],[role],','修改角色跳转','','/role/role_edit','5','3','0',NULL,'1',NULL), ('163','to_role_assign','role','[0],[system],[role],','角色分配跳转','','/role/role_assign','6','3','0',NULL,'1',NULL), ('164','role_list','role','[0],[system],[role],','角色列表','','/role/list','7','3','0',NULL,'1',NULL), ('165','to_assign_role','mgr','[0],[system],[mgr],','分配角色跳转','','/mgr/role_assign','8','3','0',NULL,'1',NULL), ('166','to_user_edit','mgr','[0],[system],[mgr],','编辑用户跳转','','/mgr/user_edit','9','3','0',NULL,'1',NULL), ('167','mgr_list','mgr','[0],[system],[mgr],','用户列表','','/mgr/list','10','3','0',NULL,'1',NULL), ('168','project','system','[0],[system],','项目管理','','/ProjectManager','11','2','1',NULL,'1',NULL), ('169','project_add','project','[0],[system],[project],','添加项目','','/ProjectManager_add','1','3','0',NULL,'1',NULL);
INSERT INTO `notice` VALUES ('6','世界','10','欢迎使用Hmc管理系统','2017-01-11 08:53:20','1'), ('8','你好',NULL,'你好','2017-05-10 19:28:57','1');
INSERT INTO `operation_log` VALUES ('480','业务日志','清空业务日志','1','com.stylefeng.guns.modular.system.controller.LogController','delLog','2017-06-03 23:04:22','成功','主键id=null'), ('481','业务日志','清空登录日志','1','com.stylefeng.guns.modular.system.controller.LoginLogController','delLog','2017-06-03 23:04:25','成功','主键id=null'), ('482','业务日志','修改菜单','1','com.stylefeng.guns.modular.system.controller.MenuController','edit','2017-06-04 10:22:58','成功','菜单名称=分配角色跳转;;;字段名称:url地址,旧值:/role/role_assign,新值:/mgr/role_assign'), ('483','业务日志','修改通知','1','com.lcc.lccshot.controller.NoticeController','update','2017-08-14 17:12:37','成功','标题=世界;;;字段名称:内容,旧值:欢迎使用Guns管理系统,新值:欢迎使用Hmc管理系统'), ('484','业务日志','菜单新增','1','com.lcc.lccshot.controller.MenuController','add','2017-08-14 17:50:08','成功','菜单名称=项目管理'), ('485','业务日志','菜单新增','1','com.lcc.lccshot.controller.MenuController','add','2017-08-14 17:52:04','成功','菜单名称=添加项目'), ('486','业务日志','修改菜单','1','com.lcc.lccshot.controller.MenuController','edit','2017-08-14 18:03:14','成功','菜单名称=项目管理;;;');
INSERT INTO `relation` VALUES ('3377','105','5'), ('3378','106','5'), ('3379','107','5'), ('3380','108','5'), ('3381','109','5'), ('3382','110','5'), ('3383','111','5'), ('3384','112','5'), ('3385','113','5'), ('3386','114','5'), ('3387','115','5'), ('3388','116','5'), ('3389','117','5'), ('3390','118','5'), ('3391','119','5'), ('3392','120','5'), ('3393','121','5'), ('3394','122','5'), ('3395','150','5'), ('3396','151','5'), ('3624','105','1'), ('3625','106','1'), ('3626','107','1'), ('3627','108','1'), ('3628','109','1'), ('3629','110','1'), ('3630','111','1'), ('3631','112','1'), ('3632','113','1'), ('3633','165','1'), ('3634','166','1'), ('3635','167','1'), ('3636','114','1'), ('3637','115','1'), ('3638','116','1'), ('3639','117','1'), ('3640','118','1'), ('3641','162','1'), ('3642','163','1'), ('3643','164','1'), ('3644','119','1'), ('3645','120','1'), ('3646','121','1'), ('3647','122','1'), ('3648','150','1'), ('3649','151','1'), ('3650','128','1'), ('3651','134','1'), ('3652','158','1'), ('3653','159','1'), ('3654','130','1'), ('3655','131','1'), ('3656','135','1'), ('3657','136','1'), ('3658','137','1'), ('3659','152','1'), ('3660','153','1'), ('3661','154','1'), ('3662','132','1'), ('3663','138','1'), ('3664','139','1'), ('3665','140','1'), ('3666','155','1'), ('3667','156','1'), ('3668','157','1'), ('3669','133','1'), ('3670','160','1'), ('3671','161','1'), ('3672','141','1'), ('3673','142','1'), ('3674','143','1'), ('3675','144','1'), ('3676','148','1'), ('3677','145','1'), ('3678','149','1'), ('3679','168','1'), ('3680','169','1');
INSERT INTO `role` VALUES ('1','1','0','超级管理员','24','administrator','1'), ('5','2','1','临时','26','temp',NULL);
INSERT INTO `test` VALUES ('1','123');
INSERT INTO `user` VALUES ('1','girl.gif','admin','ecfadcde9305f8891bcfe5a1e28c253e','8pgby','张三','2017-05-05 00:00:00','2','sn93@qq.com','18200000000','1','27','1','2016-01-29 08:49:53','25'), ('44',NULL,'test','45abb7879f6a8268f1ef600e6038ac73','ssts3','test','2017-05-01 00:00:00','1','abc@123.com','','5','26','1','2017-05-16 20:33:37',NULL);
