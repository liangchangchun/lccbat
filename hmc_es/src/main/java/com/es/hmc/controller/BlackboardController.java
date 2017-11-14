package com.es.hmc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.hmc.base.BaseController;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


/**
 * 总览信息
 *
 * @author fengshuonan
 * @Date 2017年3月4日23:05:54
 */
@Controller
@RequestMapping("/blackboard")
public class BlackboardController extends BaseController {


    /**
     * 跳转到黑板
     */
    @RequestMapping("")
    public String blackboard(Model model) {
    	Map map = Maps.newHashMap();
    	map.put("id", "1");
    	map.put("title", "你好");
    	map.put("type", "10");
    	map.put("content", "欢迎使用");
    	map.put("createtime", "2017-11-13 19:28:57");
    	map.put("creater", "1");
        List notices = Lists.newArrayList();
        notices.add(map);
        model.addAttribute("noticeList",notices);
        return "/blackboard.html";
    }
}
