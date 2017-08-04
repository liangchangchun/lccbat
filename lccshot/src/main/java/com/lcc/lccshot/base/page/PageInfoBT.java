package com.lcc.lccshot.base.page;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 分页结果的封装(for Bootstrap Table)
 *
 * @author fengshuonan
 * @Date 2017年1月22日 下午11:06:41
 */
public class PageInfoBT<T> {

    // 结果集
    private List<T> rows;

    // 总数
    private long total;

    public PageInfoBT(Page<T> page) {
        this.rows = page.getRecords();
        this.total = page.getTotal();
    }
    
    public PageInfoBT(org.springframework.data.domain.Page<T> page) {
        this.rows = page.getContent();
        this.total = page.getTotalPages();
    }
    
    public PageInfoBT(List<T> result) {
        this.rows = result;
        this.total = result.size();
    }
    public PageInfoBT(Collection<T> result) {
    	Object[] o = result.toArray();
        this.rows = (List<T>) Arrays.asList(o);
        this.total = result.size();
    }
    
    public PageInfoBT(){
    	
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
