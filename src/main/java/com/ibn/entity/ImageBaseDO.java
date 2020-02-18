package com.ibn.entity;

import lombok.Data;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.entity
 * @date ：2020/2/6 09:22
 * @description：图片基础类
 * @version: 1.0
 */
@Data
public class ImageBaseDO {
    /**
     * @author: RenBin
     * @description: 主键
     * @date: 2020/2/6 09:23
     */
    private Long id;
    /**
     * @author: RenBin
     * @description: 文件名
     * @date: 2020/2/6 09:29
     */
    private String name;
    /**
     * @author: RenBin
     * @description: 图片
     * @date: 2020/2/6 09:29
     */
    private byte[] image;
    /**
     * @author: RenBin
     * @description: 创建时间
     * @date: 2020/2/6 09:29
     */
    private Long createTime;
}
