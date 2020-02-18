package com.ibn.service.impl;

import com.ibn.dao.MenuBaseDao;
import com.ibn.domain.MenuBaseDTO;
import com.ibn.entity.MenuBaseDO;
import com.ibn.service.MenuBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.service.impl
 * @date ：2020/1/26 14:59
 * @description：菜单相关操作实现类
 * @version: 1.0
 */
@Service("menuBaseService")
public class MenuBaseServiceImpl implements MenuBaseService {
    @Autowired
    private MenuBaseDao menuBaseDao;
    @Override
    public List<MenuBaseDTO> queryMenuBaseTree(Long userId) {
        return menuBaseDao.queryMenuBaseTree(userId);
    }

    @Override
    public Long addMenuBase(MenuBaseDO menuBaseDO) {
        return menuBaseDao.addMenuBase(menuBaseDO);
    }

    @Override
    public Long deleteMenuBase(Long id) {
        return menuBaseDao.deleteMenuBase(id);
    }

    @Override
    public Long updateMenuBase(MenuBaseDO menuBaseDO) {
        return menuBaseDao.updateMenuBase( menuBaseDO);
    }
}
