package com.ibn.controller;

import com.ibn.constant.CacheConst;
import com.ibn.enumerate.HeaderEnum;
import com.ibn.service.ImageCodeService;
import com.ibn.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @description: 基础服务
 * @projectName：mylog-support
 * @see: com.ibn.controller
 * @author： RenBin
 * @createTime：2020/1/20 15:17
 */
@Api(value = "公共服务基础接口", tags = "公共服务基础接口")
@RestController
public class CommonBaseController {
    @Autowired
    private ImageCodeService imageCodeService;
    @Autowired
    private RedisTemplate redisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CommonBaseController.class);
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
    /**
     * @description: 获取验证码
     * @author：RenBin
     * @createTime：2020/1/20 16:01
     */
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    @RequestMapping(method = RequestMethod.GET, path = "imageCode")
    public void getImageCode(HttpServletResponse response) {
        BufferedImage bufferedImage = imageCodeService.getImage();
        response.addHeader("Access-Control-Expose-Headers", HeaderEnum.AUTHORIZATION.getValues());
        String token= MD5Util.getMd5Code(UUID.randomUUID().toString());
        response.addHeader(HeaderEnum.AUTHORIZATION.getValues(), token);
        try {
            imageCodeService.output(bufferedImage, response.getOutputStream());
        } catch (IOException e) {
            logger.error("获取验证码失败", e);
        }
        redisTemplate.opsForValue().set(CacheConst.IMAGE_CODE+token, imageCodeService.getText(), 60 * 2, TimeUnit.SECONDS);
    }
}
