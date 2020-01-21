package com.ibn.service;

import com.ibn.entity.UserBaseDO;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.service
 * @author： RenBin
 * @createTime：2020/1/20 16:43
 */
public interface UserBaseService {
    /**
     * @description: 根据userBaseDO中的参数查询
     * @author：RenBin
     * @createTime：2020/1/20 16:44
     */
    UserBaseDO queryUserBaseByDO(UserBaseDO userBaseDO);

    Long saveUserBase(UserBaseDO userBaseDO);
}
