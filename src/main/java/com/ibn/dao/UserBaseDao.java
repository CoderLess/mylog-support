package com.ibn.dao;

import com.ibn.entity.UserBaseDO;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.dao
 * @author： RenBin
 * @createTime：2020/1/20 16:26
 */
public interface UserBaseDao {
    UserBaseDO queryUserBaseByDO(UserBaseDO userBaseDO);
    Long saveUserBase(UserBaseDO userBaseDO);
}
