package com.ibn.controller;

import com.ibn.base.entity.ResultInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.controller
 * @author： RenBin
 * @createTime：2020/1/21 15:01
 */
@RestController
@RequestMapping(path = "menus")
public class MenuBaseController {

    @RequestMapping(path = "{userId}", method = RequestMethod.GET)
    public ResultInfo<Object> queryMenuByUserId(@PathVariable Long userId) {

    }
}
