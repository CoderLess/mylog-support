package com.ibn.vo;

import com.ibn.base.entity.BaseVO;
import lombok.Data;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.vo
 * @date ：2020/2/6 07:37
 * @description：文章基本信息对象
 * @version: 1.0
 */
@Data
public class ArticleBaseVO extends BaseVO {
    /**
     * @author: RenBin
     * @description: 主键
     * @date: 2020/2/7 21:22
     */
    private Long id;
    /**
     * @author: RenBin
     * @description: 分类id
     * @date: 2020/2/6 07:39
     */
    private Long menuId;
    /**
     * @author: RenBin
     * @description: 文章标题
     * @date: 2020/2/6 07:38
     */
    private String title;
    /**
     * @author: RenBin
     * @description: 文章内容
     * @date: 2020/2/6 07:39
     */
    private String content;
    /**
     * @author: RenBin
     * @description: 版本
     * @date: 2020/2/9 15:45
     */
    private Long version;
}
