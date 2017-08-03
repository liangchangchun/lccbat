package com.lcc.lccshot.core.constant.factory;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lcc.lccshot.core.constant.cache.Cache;
import com.lcc.lccshot.core.constant.cache.CacheKey;
import com.lcc.lccshot.core.constant.state.ManagerStatus;
import com.lcc.lccshot.core.constant.state.MenuStatus;
import com.lcc.lccshot.core.constant.state.Sex;
import com.lcc.lccshot.core.log.LogObjectHolder;
import com.lcc.lccshot.domain.Dept;
import com.lcc.lccshot.domain.Dict;
import com.lcc.lccshot.domain.Menu;
import com.lcc.lccshot.domain.Notice;
import com.lcc.lccshot.domain.Role;
import com.lcc.lccshot.domain.User;
import com.lcc.lccshot.repository.DeptRepository;
import com.lcc.lccshot.repository.DictRepository;
import com.lcc.lccshot.repository.MenuRepository;
import com.lcc.lccshot.repository.NoticeRepository;
import com.lcc.lccshot.repository.RoleRepository;
import com.lcc.lccshot.repository.UserRepository;
import com.lcc.lccshot.utils.Convert;
import com.lcc.lccshot.utils.SpringContextHolder;
import com.lcc.lccshot.utils.StrKit;
import com.lcc.lccshot.utils.ToolUtil;

/**
 * 常量的生产工厂
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:55:21
 */
@Component
@DependsOn("springContextHolder")
public class LogicConstantFactory implements IConstantFactory {

    private RoleRepository roleMapper = SpringContextHolder.getBean(RoleRepository.class);
    private DeptRepository deptMapper = SpringContextHolder.getBean(DeptRepository.class);
    private DictRepository dictMapper = SpringContextHolder.getBean(DictRepository.class);
    private UserRepository userMapper = SpringContextHolder.getBean(UserRepository.class);
    private MenuRepository menuMapper = SpringContextHolder.getBean(MenuRepository.class);
    private NoticeRepository noticeMapper = SpringContextHolder.getBean(NoticeRepository.class);

    public static IConstantFactory me() {
        return SpringContextHolder.getBean(IConstantFactory.class);
    }

    /**
     * 根据用户id获取用户名称
     *
     * @author stylefeng
     * @Date 2017/5/9 23:41
     */
    public String getUserNameById(Integer userId) {
        User user = userMapper.findById(userId);
        if (user != null) {
            return user.getName();
        } else {
            return "--";
        }
    }

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    public String getUserAccountById(Integer userId) {
        User user = userMapper.findById(userId);
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }

    /**
     * 通过角色ids获取角色名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.ROLES_NAME + "'+#roleIds")
    public String getRoleName(String roleIds) {
        Integer[] roles = Convert.toIntArray(roleIds);
        StringBuilder sb = new StringBuilder();
        for (int role : roles) {
            Role roleObj = roleMapper.findById(role);
            if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
                sb.append(roleObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 通过角色id获取角色名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_NAME + "'+#roleId")
    public String getSingleRoleName(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleMapper.findById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }

    /**
     * 通过角色id获取角色英文名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.SINGLE_ROLE_TIP + "'+#roleId")
    public String getSingleRoleTip(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleMapper.findById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getTips();
        }
        return "";
    }

    /**
     * 获取部门名称
     */
    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.DEPT_NAME + "'+#deptId")
    public String getDeptName(Integer deptId) {
        Dept dept = deptMapper.findById(deptId);
        if (ToolUtil.isNotEmpty(dept) && ToolUtil.isNotEmpty(dept.getFullname())) {
            return dept.getFullname();
        }
        return "";
    }

    /**
     * 获取菜单的名称们(多个)
     */
    public String getMenuNames(String menuIds) {
        Integer[] menus = Convert.toIntArray(menuIds);
        StringBuilder sb = new StringBuilder();
        for (int menu : menus) {
            Menu menuObj = menuMapper.findById(menu);
            if (ToolUtil.isNotEmpty(menuObj) && ToolUtil.isNotEmpty(menuObj.getName())) {
                sb.append(menuObj.getName()).append(",");
            }
        }
        return StrKit.removeSuffix(sb.toString(), ",");
    }

    /**
     * 获取菜单名称
     */
    public String getMenuName(Integer menuId) {
        if (ToolUtil.isEmpty(menuId)) {
            return "";
        } else {
            Menu menu = menuMapper.findById(menuId);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取菜单名称通过编号
     */
    public String getMenuNameByCode(String code) {
        if (ToolUtil.isEmpty(code)) {
            return "";
        } else {
           // Menu param = new Menu();
           // param.setCode(code);
            Menu menu = menuMapper.findByCode(code);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    /**
     * 获取字典名称
     */
    public String getDictName(Integer dictId){
        if (ToolUtil.isEmpty(dictId)) {
            return "";
        } else {
            Dict dict = dictMapper.findById(dictId);
            if (dict == null) {
                return "";
            } else {
                return dict.getName();
            }
        }
    }

    /**
     * 获取通知标题
     */
    public String getNoticeTitle(Integer dictId){
        if (ToolUtil.isEmpty(dictId)) {
            return "";
        } else {
            Notice notice = noticeMapper.findById(dictId);
            if (notice == null) {
                return "";
            } else {
                return notice.getTitle();
            }
        }
    }

    /**
     * 获取性别名称
     */
    public String getSexName(Integer sex) {
        return Sex.valueOf(sex);
    }

    /**
     * 获取用户登录状态
     */
    public String getStatusName(Integer status) {
        return ManagerStatus.valueOf(status);
    }

    /**
     * 获取菜单状态
     */
    public String getMenuStatusName(Integer status) {
        return MenuStatus.valueOf(status);
    }

    /**
     * 查询字典
     */
    public List<Dict> findInDict(Integer id) {
        if (ToolUtil.isEmpty(id)) {
            return null;
        } else {
            EntityWrapper<Dict> wrapper = new EntityWrapper<Dict>();
           // List<Dict> dicts = dictMapper.selectList(wrapper.eq("pid", id));
            List<Dict> dicts =  dictMapper.findByPid(id);
            if (dicts == null || dicts.size() == 0) {
                return null;
            } else {
                return dicts;
            }
        }
    }

    /**
     * 获取被缓存的对象(用户删除业务)
     */
    public String getCacheObject(String para) {
        return LogObjectHolder.me().get().toString();
    }

}
