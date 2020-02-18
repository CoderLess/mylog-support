package com.ibn.dao;

import com.ibn.domain.MenuBaseDTO;
import com.ibn.entity.MenuBaseDO;
import com.ibn.entity.UserBaseDO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn.dao
 * @author： RenBin
 * @createTime：2020/1/20 16:26
 */
public interface MenuBaseDao {
    /**
     * @author: RenBin
     * @description: 根据用户id查询对应的菜单树
     * @date: 2020/2/10 22:10
     */
    List<MenuBaseDTO> queryMenuBaseTree(Long userId);
    /**
     * @author: RenBin
     * @description: 添加菜单项
     * @date: 2020/2/10 22:10
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
     * @description: 更新菜单信息
     * @date: 2020/2/11 08:49
     */
    Long updateMenuBase(MenuBaseDO menuBaseDO);
}
