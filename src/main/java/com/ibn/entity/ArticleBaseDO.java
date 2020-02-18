package com.ibn.entity;

import lombok.Data;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.entity
 * @date ：2020/1/31 17:24
 * @description：文章基本信息
 * @version: 1.0
 */
@Data
public class ArticleBaseDO {
    private Long id;
    private Long menuId;
    private String title;
    private String content;
    private Long createTime;
    private Long accessTime;
    private Long version;

}
