package com.lcc.lccshot.base;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.domain.OperationLog;
import com.lcc.lccshot.utils.Contrast;
import com.lcc.lccshot.utils.Convert;
import com.lcc.lccshot.utils.ToolUtil;

/**
 * 控制器查询结果的包装类基类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:49:36
 */
public abstract class BaseControllerWarpper {

    private Object obj = null;
    private Class type = null;

    public BaseControllerWarpper(Object obj) {
        this.obj = obj;
    }
    public BaseControllerWarpper(Object obj,Class type) {
        this.obj = obj;
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public Object warp() {
        if (this.obj instanceof List) {
           // List<Map<String, Object>> list = (List<Map<String, Object>>) this.obj;
        	List list = (List)this.obj;
        	List<Map<String, Object>> listMap = Lists.newArrayList();
            for (Object o : list) {
            	if (o instanceof Map) {
            		warpTheMap((Map<String, Object>)o);
            	} else {
            		listMap.add(warpTheEntity(o));
            	}
            }
            return type==null?list:listMap;
        } else if (this.obj instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) this.obj;
            warpTheMap(map);
            return map;
        } else {
            return this.obj;
        }
    }
    /**
     * page行对象 转换
     * @return
     */
    public Page page(){
    	if (this.obj instanceof Page) {
    		Page result =(Page)this.obj;
    		Page<Map> res =result.map(new Converter<Object, Map>() {
			@Override
			public Map convert(Object source) {
				return warpTheEntity(source);
				}
			});
    		return res;
    	} else {
    		return (Page)this.obj;
    	}
    }

    protected abstract void warpTheMap(Map<String, Object> map);
    
    protected Map warpTheEntity( Object entity) {
    	Field[] fields =  type.getDeclaredFields();
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
    	for (Field field : fields) {    
            	field.setAccessible(true);  
				map.put(field.getName(), field.get(entity));
        	}    
    	} catch (IllegalArgumentException e) {
    		
		} catch (IllegalAccessException e) {
			
		}  
    	warpTheMap(map);
    	return map;
    }
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Class getType() {
		return type;
	}
	public void setType(Class type) {
		this.type = type;
	};
    
    
}
