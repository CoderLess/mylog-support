package com.ibn.controller;

import com.ibn.annotation.NotNeedLogin;
import com.ibn.base.entity.ResultInfo;
import com.ibn.constant.CacheConst;
import com.ibn.entity.UserBaseDO;
import com.ibn.enumerate.HeaderEnum;
import com.ibn.service.CommonBaseService;
import com.ibn.service.UserBaseService;
import com.ibn.util.BeanUtil;
import com.ibn.util.TokenUtil;
import com.ibn.vo.UserBaseVO;
import com.ibn.vo.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.controller
 * @author： RenBin
 * @createTime：2020/1/20 16:01
 */
@Api(value = "用户服务基础接口", tags = "用户服务基础接口")
@RestController
@RequestMapping(path = "users")
public class UserBaseController {
    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private CommonBaseService commonBaseService;

    @NotNeedLogin
    @ApiOperation(value = "用户登入", notes = "用户登入")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResultInfo<Object> userLogin(@Validated @RequestBody UserBaseVO userBaseVO,
                                        HttpServletRequest request) {
        // 获取token
        String imgToken = request.getHeader(HeaderEnum.IMG_TOKEN.getValues());
        // 获取验证码
        String validateCode = userBaseVO.getValidateCode();
        // 检测一下验证码是否正确
        if (!commonBaseService.checkValidateCode(CacheConst.IMAGE_CODE + imgToken, validateCode)) {
            return new ResultInfo<>().error("验证码输入错误或超时,请重新输入");
        }
        // 检测用户名密码是否正确
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtil.copyProperties(userBaseVO, userBaseDO);
        UserBaseDO userBaseDOQuery = userBaseService.queryUserBaseByDO(userBaseDO);
        // 存储用户相关信息返回给前台
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtil.copyProperties(userBaseDOQuery,userInfoVO);
        if (null != userBaseDOQuery && null != userBaseDOQuery.getId()) {
            String token = TokenUtil.createToken(userBaseDOQuery);
            userInfoVO.setToken(token);
            return new ResultInfo<>().response(userInfoVO);
        }
        return new ResultInfo<>().error("用户名或密码错误");
    }

    @NotNeedLogin
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResultInfo<Object> userRegister(@RequestBody UserBaseVO userBaseVO, HttpServletRequest request) {
        // 获取token
        String token = request.getHeader(HeaderEnum.IMG_TOKEN.getValues());
        // 获取验证码
        String validateCode = userBaseVO.getValidateCode();
        // 检测一下验证码是否正确
        if (!commonBaseService.checkValidateCode(CacheConst.IMAGE_CODE + token, validateCode)) {
            return new ResultInfo<>().error("验证码输入错误或超时,请重新输入");
        }
        if (!userBaseVO.getPassWord().equals(userBaseVO.getRepassWord())) {
            return new ResultInfo<>().error("两次输入密码不一致,请重新输入");
        }
        // 保存用户信息
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtil.copyProperties(userBaseVO, userBaseDO);
        Long userId = userBaseService.saveUserBase(userBaseDO);
        if (null != userId && userId > 0) {
            return new ResultInfo<>().success("注册成功");
        }
        return new ResultInfo<>().error("注册失败,请重新注册");
    }
}
