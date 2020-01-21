package com.ibn.util;

import org.springframework.beans.BeanUtils;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.util
 * @author： RenBin
 * @createTime：2020/1/21 8:03
 */
public class AbstractObject {
    /**
     * @description: 浅度克隆
     * @author：RenBin
     * @createTime：2020/1/21 8:04
     */
    public <T> T clone(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        T target = clazz.newInstance();
        BeanUtils.copyProperties(this, target);
        return target;
    }
    /**
     * @description: 浅度克隆
     * @author：RenBin
     * @createTime：2020/1/21 8:04
     */
    public <T> T clone(T target) {
        BeanUtils.copyProperties(this, target);
        return target;
    }
}
