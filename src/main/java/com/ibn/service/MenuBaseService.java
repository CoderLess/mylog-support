package com.ibn.service;

import com.ibn.domain.MenuBaseDTO;
import com.ibn.entity.MenuBaseDO;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.service
 * @date ：2020/1/26 14:53
 * @description：菜单操作接口
 * @version: 1.0
 */
public interface MenuBaseService {
    /**
     * @author: RenBin
     * @description: 获取用户对应的菜单
     * @date: 2020/1/26 14:58
     */
    List<MenuBaseDTO> queryMenuBaseTree(Long userId);
    /**
     * @author: RenBin
     * @description: 添加菜单信息
     * @date: 2020/2/10 22:09
     */
    Long addMenuBase(MenuBaseDO menuBaseDO);
    /**
     * @author: RenBin
     * @description: 删除菜单
     * @date: 2020/2/11 08:27
     */
    Long deleteMenuBase(Long id);
    /**
     * @author: RenBin
     * @description: 更新菜单
     * @date: 2020/2/11 08:48
     */
    Long updateMenuBase(MenuBaseDO menuBaseDO);
}
