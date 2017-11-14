package com.es.hmc.constant.factory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.es.hmc.constant.state.Order;
import com.es.hmc.utils.HttpKit;
import com.es.hmc.utils.ToolUtil;


/**
 * BootStrap Table默认的分页参数创建
 *
 * @author fengshuonan
 * @date 2017-04-05 22:25
 */
public class PageFactory {
	/*
    public Page<T> defaultPage() {
        HttpServletRequest request = HttpKit.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        if(ToolUtil.isEmpty(sort)){
            Page<T> page = new Page<>((offset / limit + 1), limit);
            page.setOpenSort(false);
            return page;
        }else{
            Page<T> page = new Page<>((offset / limit + 1), limit, sort);
            if(Order.ASC.getDes().equals(order)){
                page.setAsc(true);
            }else{
                page.setAsc(false);
            }
            return page;
        }
    }
   */
    public Pageable simplePage(){
    	 HttpServletRequest request = HttpKit.getRequest();
         int limit = Integer.valueOf(request.getParameter("limit"));
         int offset = Integer.valueOf(request.getParameter("offset"));
         String sort = request.getParameter("sort");
         String order = request.getParameter("order");
         Pageable pageable = null;
         if(ToolUtil.isEmpty(sort)){
        	 pageable =new PageRequest((offset / limit ), limit);
         }else{
        	 Sort st = null;
        	 if(Order.ASC.getDes().equals(order)){
        		 st = new Sort(Direction.ASC, sort);
             }else{
            	 st = new Sort(Direction.DESC, sort);
             }
        	 int page = (offset / limit ) ;
        	 pageable = new PageRequest(page, limit, st);
         }
     	return pageable;
    }
    
    
    
    
}
