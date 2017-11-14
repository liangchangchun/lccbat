package com.es.hmc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.es.hmc.base.BaseController;
import com.es.hmc.exception.InvalidKaptchaException;
import com.es.hmc.utils.ToolUtil;
import com.google.code.kaptcha.Constants;



@Controller
public class LoginController extends BaseController{

	 
    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        //获取菜单列表

       // model.addAttribute("titles", titles);
        //获取用户头像
        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
 
            return "/index.html";
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali() {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();

        //验证验证码是否正确
        if(ToolUtil.getKaptchaOnOff()){
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(ToolUtil.isEmpty(kaptcha) || !kaptcha.equals(code)){
                throw new InvalidKaptchaException();
            }
        }

       // Subject currentUser = ShiroKit.getSubject();
      //  UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
      //  token.setRememberMe(true);

      //  currentUser.login(token);

       // ShiroUser shiroUser = ShiroKit.getUser();
       // super.getSession().setAttribute("shiroUser", shiroUser);
       // super.getSession().setAttribute("username", shiroUser.getAccount());

       // LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

       // ShiroKit.getSession().setAttribute("sessionFlag",true);

        return REDIRECT + "/";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
       // LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
        //ShiroKit.getSubject().logout();
        return REDIRECT + "/index.html";
    }

}
