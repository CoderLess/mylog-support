package com.ibn.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ibn.constant.TokenConst;
import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.UserBaseDO;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.util
 * @date ：2020/1/27 19:28
 * @description：处理token的相关操作
 * @version: 1.0
 */
public class TokenUtil {
    /**
     * @author: RenBin
     * @description: 获取用户对应的token值
     * @date: 2020/1/27 19:33
     */
    public static String createToken(UserBaseDO userBaseDO) {
        Date start = new Date();
        // 一小时有效时间
//        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;
//        Date end = new Date(currentTime);
        String token = JWT.create().withAudience(userBaseDO.getId().toString())
                .withIssuedAt(start)
//                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(userBaseDO.getPassWord()));
        return token;
    }
    /**
     * @author: RenBin
     * @description: 从token中取出用户id
     * @date: 2020/1/27 19:37
     */
    public static UserBaseDTO getTokenInfo(HttpServletRequest request) {
        // 从 http 请求头中取出 token
        String token = request.getHeader(TokenConst.TOKEN_HEADER);
        // 获取userId
        String userId = JWT.decode(token).getAudience().get(0);
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setId(Long.valueOf(userId));
        return userBaseDTO;
    }
}
