package com.ibn.service.impl;

import com.ibn.service.CommonBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.service.impl
 * @author： RenBin
 * @createTime：2020/1/20 16:54
 */
@Service("commonBaseService")
public class CommonBaseServiceImpl implements CommonBaseService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Boolean checkValidateCode(String token, String code) {
        String value= (String) redisTemplate.opsForValue().get(token);
        if (null != value && value.equalsIgnoreCase(code)) {
            return true;
        }
        return false;
    }

}
