package com.ibn.service.impl;

import com.ibn.dao.UserBaseDao;
import com.ibn.entity.UserBaseDO;
import com.ibn.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.service.impl
 * @author： RenBin
 * @createTime：2020/1/20 16:46
 */
@Service("userBaseService")
public class UserBaseServiceImpl implements UserBaseService {
    @Autowired
    private UserBaseDao userBaseDao;
    @Override
    public UserBaseDO queryUserBaseByDO(UserBaseDO userBaseDO) {
        return userBaseDao.queryUserBaseByDO(userBaseDO);
    }

    @Override
    public Long saveUserBase(UserBaseDO userBaseDO) {
        return userBaseDao.saveUserBase(userBaseDO);
    }
}
