package com.es.hmc.base;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 错误页面的默认跳转
 *
 * @author fengshuonan
 * @date 2017-05-21 11:34
 */
@Component("error")
public class BaseErrorView implements View{

    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.getRequestDispatcher("/global/error").forward(httpServletRequest,httpServletResponse);
    }
}
