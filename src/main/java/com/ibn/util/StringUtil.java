package com.ibn.util;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.util
 * @date ：2020/1/30 18:03
 * @description：字符串工具类
 * @version: 1.0
 */
public class StringUtil {
    /**
     * @author: RenBin
     * @description: 字符串是否为空
     * @date: 2020/1/30 18:07
     */
    public static Boolean isEmpty(String checkString) {
        return checkString == null || checkString.trim().length() == 0;
    }
    
    /**
     * @author: RenBin
     * @description: 字符串是否不为空
     * @date: 2020/1/30 18:07
     */
    public static Boolean isNotEmpty(String checkString) {
        return !isEmpty(checkString);
    }
}
