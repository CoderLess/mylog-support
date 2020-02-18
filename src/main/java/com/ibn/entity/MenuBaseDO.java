package com.ibn.entity;

import lombok.Data;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.domain
 * @date ：2020/1/26 14:31
 * @description：菜单传输层对象
 * @version: 1.0
 */
@Data
public class MenuBaseDO {
    private Long id;
    /**
     * @author: RenBin
     * @description: 用户id
     * @date: 2020/2/10 22:18
     */
    private Long userId;
    /**
     * @author: RenBin
     * @description: 父级id
     * @date: 2020/2/10 22:18
     */
    private Long parentId;
    /**
     * @author: RenBin
     * @description: 菜单名称
     * @date: 2020/2/10 22:18
     */
    private String menuName;
    /**
     * @author: RenBin
     * @description: 创建时间
     * @date: 2020/2/10 22:18
     */
    private Long createTime;
    /**
     * @author: RenBin
     * @description: 修改时间
     * @date: 2020/2/11 08:45
     */
    private Long accessTime;
    /**
     * @author: RenBin
     * @description: 版本
     * @date: 2020/2/11 08:45
     */
    private Long version;

}
