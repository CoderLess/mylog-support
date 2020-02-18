package com.ibn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.annotation
 * @date ：2020/1/27 17:37
 * @description：标记需要登入才能访问的方法
 * @version: 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNeedLogin {
}
