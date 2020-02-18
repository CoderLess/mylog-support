package com.ibn.controller;

import com.ibn.base.entity.ResultInfo;
import com.ibn.domain.MenuBaseDTO;
import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.MenuBaseDO;
import com.ibn.service.MenuBaseService;
import com.ibn.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private MenuBaseService menuBaseService;
    /**
     * @author: RenBin
     * @description: 根据用户id获取对应的菜单树
     * @date: 2020/2/11 08:41
     */
    @RequestMapping(path = "{userId}", method = RequestMethod.GET)
    public ResultInfo<Object> queryMenuByUserId(@PathVariable Long userId) {
        List<MenuBaseDTO> menuBaseDTOList = menuBaseService.queryMenuBaseTree(userId);
        return new ResultInfo<>().response(menuBaseDTOList);
    }
    /**
     * @author: RenBin
     * @description: 新增菜单
     * @date: 2020/2/11 08:41
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResultInfo<Object> addMenuByUserId(@RequestBody MenuBaseDO menuBaseDO, HttpServletRequest request) {
        if (null == menuBaseDO) {
            return new ResultInfo<>().error("参数错误");
        }
        UserBaseDTO userBaseDTO = TokenUtil.getTokenInfo(request);
        menuBaseDO.setUserId(userBaseDTO.getId());
        menuBaseDO.setCreateTime(System.currentTimeMillis());
        Long menuId = menuBaseService.addMenuBase(menuBaseDO);
        if (null == menuId || 0 == menuId) {
            return new ResultInfo<>().error("添加失败");
        }
        return new ResultInfo<>().success("添加成功");
    }
    /**
     * @author: RenBin
     * @description: 删除菜单
     * @date: 2020/2/11 08:41
     */
    @RequestMapping(path = "{menuId}",method = RequestMethod.DELETE)
    public ResultInfo<Object> addMenuByUserId(@PathVariable("menuId") Long menuId, HttpServletRequest request) {
        if (null == menuId || 0 == menuId) {
            return new ResultInfo<>().error("参数错误");
        }
        menuBaseService.deleteMenuBase(menuId);
        return new ResultInfo<>().success("删除成功");
    }
    /**
     * @author: RenBin
     * @description: 修改菜单
     * @date: 2020/2/11 08:41
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultInfo<Object> updateMenuBase(@RequestBody MenuBaseDO menuBaseDO, HttpServletRequest request) {
        if (null == menuBaseDO) {
            return new ResultInfo<>().error("参数错误");
        }
        menuBaseDO.setAccessTime(System.currentTimeMillis());
        Long menuId = menuBaseService.updateMenuBase(menuBaseDO);
        if (null == menuId || 0 == menuId) {
            return new ResultInfo<>().error("添加失败");
        }
        return new ResultInfo<>().success("添加成功");
    }
}
