package com.lcc.lccshot.core.dictmap.factory;

import java.lang.reflect.Method;

import com.lcc.lccshot.core.constant.factory.LogicConstantFactory;
import com.lcc.lccshot.core.constant.factory.IConstantFactory;
import com.lcc.lccshot.exception.BizExceptionEnum;
import com.lcc.lccshot.exception.BussinessException;

/**
 * 字段的包装创建工厂
 *
 * @author fengshuonan
 * @date 2017-05-06 15:12
 */
public class DictFieldWarpperFactory {

    public static Object createFieldWarpper(Object field, String methodName) {
    	IConstantFactory me = LogicConstantFactory.me();
        try {
            Method method = LogicConstantFactory.class.getMethod(methodName, field.getClass());
            Object result = method.invoke(me, field);
            return result;
        } catch (Exception e) {
            try {
                Method method = LogicConstantFactory.class.getMethod(methodName, Integer.class);
                Object result = method.invoke(me, Integer.parseInt(field.toString()));
                return result;
            } catch (Exception e1) {
                throw new BussinessException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            }
        }
    }

}
