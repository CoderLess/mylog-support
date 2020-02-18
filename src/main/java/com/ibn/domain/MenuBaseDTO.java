package com.ibn.domain;

import com.ibn.entity.MenuBaseDO;
import lombok.Data;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.domain
 * @date ：2020/1/26 14:31
 * @description：菜单传输层对象
 * @version: 1.0
 */
@Data
public class MenuBaseDTO {
    private Long id;
    private String menuName;
    private Long createTime;
    private List<MenuBaseDO> subMenuList;
}
