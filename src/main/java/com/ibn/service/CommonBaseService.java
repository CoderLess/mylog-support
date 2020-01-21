package com.ibn.service;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.service
 * @author： RenBin
 * @createTime：2020/1/20 16:53
 */
public interface CommonBaseService {
    /**
     * @description: 检查验证码是否匹配
     * @author：RenBin
     * @createTime：2020/1/20 16:54
     */
    Boolean checkValidateCode(String token, String code);
}
