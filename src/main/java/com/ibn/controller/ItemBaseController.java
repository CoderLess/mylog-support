package com.ibn.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.base.entity.ResultInfo;
import com.ibn.constant.CacheConst;
import com.ibn.domain.UserBaseDTO;
import com.ibn.util.TokenUtil;
import com.ibn.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.controller
 * @date ：2020/2/12 21:08
 * @description：事务管理
 * @version: 1.0
 */
@RestController
@RequestMapping("items")
public class ItemBaseController {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(method = RequestMethod.POST)
    public ResultInfo<Object> saveItems(@RequestBody ItemVO itemVO, HttpServletRequest request) {
        UserBaseDTO userBaseDTO=TokenUtil.getTokenInfo(request);
        redisTemplate.opsForValue().set(CacheConst.ITEM+userBaseDTO.getId(), JSONObject.toJSONString(itemVO));
        return new ResultInfo<>().success("ok");
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResultInfo<Object> getItems(HttpServletRequest request) {
        UserBaseDTO userBaseDTO=TokenUtil.getTokenInfo(request);
        String itemString = (String) redisTemplate.opsForValue().get(CacheConst.ITEM+userBaseDTO.getId());
        ItemVO itemVO = JSONObject.parseObject(itemString , ItemVO.class);
        return new ResultInfo<>().response(itemVO);
    }
}
