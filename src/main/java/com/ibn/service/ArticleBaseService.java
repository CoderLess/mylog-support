package com.ibn.service;

import com.ibn.domain.ArticleBaseDTO;
import com.ibn.entity.ArticleBaseDO;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.service
 * @date ：2020/1/31 17:33
 * @description：文章基本信息处理
 * @version: 1.0
 */
public interface ArticleBaseService {
    /**
     * @author: RenBin
     * @description: 根据文章基本信息查询
     * @date: 2020/1/31 17:35
     */
    List<ArticleBaseDO> queryArticleBaseByDTO(ArticleBaseDTO articleBaseDTO);
    /**
     * @author: RenBin
     * @description: 根据id查询文章信息
     * @date: 2020/2/6 07:47
     */
    ArticleBaseDO queryArticleBaseById(Long articleId);
    /**
     * @author: RenBin
     * @description: 保存文章信息
     * @date: 2020/2/6 07:48
     */
    Long saveArticle(ArticleBaseDO articleBaseDO);
    /**
     * @author: RenBin
     * @description: 更新文章相关信息
     * @date: 2020/2/7 21:25
     */
    Long updateArticle(ArticleBaseDO articleBaseDO);

    /**
     * @author: RenBin
     * @description: 删除文章
     * @date: 2020/2/10 18:53
     */
    Long deleteArticle(Long id);
}
