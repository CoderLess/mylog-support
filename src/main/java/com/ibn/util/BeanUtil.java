package com.ibn.util;

import org.springframework.cglib.beans.BeanCopier;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeanUtils;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.util
 * @author： RenBin
 * @createTime：2020/1/20 16:57
 */
public class BeanUtil extends BeanUtils implements Serializable {

    private static final long serialVersionUID = -1069013901737839901L;
    /**
     * BeanCopier缓存
     */
    private static Map<String, BeanCopier> beanCopierCacheMap = new ConcurrentHashMap<>();

    /**
     * @description: bean复制
     * @author：RenBin
     * @createTime：2019/12/9 11:29
     */
    public static void copyProperties(Object source, Object target){
        String cacheKey = source.getClass().toString() + target.getClass().toString();
        BeanCopier beanCopier;
        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            synchronized(BeanUtils.class) {
                if(!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                } else {
                    beanCopier = beanCopierCacheMap.get(cacheKey);
                }
            }
        } else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }
        beanCopier.copy(source, target, null);
    }

}
