package com.ibn.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.ibn.annotation.NotNeedLogin;
import com.ibn.constant.TokenConst;
import com.ibn.entity.UserBaseDO;
import com.ibn.service.UserBaseService;
import com.ibn.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @description: 用户认证的拦截器
 * @projectName：ibn_cblog
 * @see: com.ibn.clog.mgt.interceptor
 * @author： RenBin
 * @createTime：2019/12/18 14:39
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserBaseService userBaseService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 验证通过将重新写入新的token
//        success.setHeader("Access-Control-Expose-Headers" , TokenConst.TOKEN_HEADER);
//        success.setHeader(TokenConst.TOKEN_HEADER,"");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        // 如果标注了不需要登入的注解则可以直接进行访问
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(NotNeedLogin.class)) {
            return true;
        }
        // 从 http 请求头中取出 token
        String token = request.getHeader(TokenConst.TOKEN_HEADER);
        // 执行认证
        if (StringUtil.isEmpty(token)) {
            throw new RuntimeException("无token，请重新登录");
        }
        // 获取 token 中的 user id
        Long userId;
        try {
            userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setId(userId);

        userBaseDO = userBaseService.queryUserBaseByDO(userBaseDO);
        if (userBaseDO == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userBaseDO.getPassWord())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        httpServletResponse.addHeader("Access-Control-Expose-Headers" , TokenConst.TOKEN_HEADER);
        httpServletResponse.addHeader(TokenConst.TOKEN_HEADER,"111111");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}