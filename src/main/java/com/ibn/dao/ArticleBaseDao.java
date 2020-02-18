package com.ibn.dao;

import com.ibn.domain.ArticleBaseDTO;
import com.ibn.domain.MenuBaseDTO;
import com.ibn.entity.ArticleBaseDO;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.dao
 * @date ：2020/1/31 17:26
 * @description：查询文章相关信息Dao
 * @version: 1.0
 */
public interface ArticleBaseDao {
    /**
     * @author: RenBin
     * @description: 根据文章信息查询
     * @date: 2020/1/31 17:29
     */
    List<ArticleBaseDO> queryArticleBaseByDTO(ArticleBaseDTO articleBaseDTO);
    /**
     * @author: RenBin
     * @description: 根据id查询文章详细信息
     * @date: 2020/2/1 11:51
     */
    ArticleBaseDO queryArticleBaseById(Long articleId);
    /**
     * @author: RenBin
     * @description: 保存文章信息
     * @date: 2020/2/6 07:54
     */
    Long saveArticle(ArticleBaseDO articleBaseDO);
    /**
     * @author: RenBin
     * @description: 更新文章信息
     * @date: 2020/2/7 21:25
     */
    Long updateArticle(ArticleBaseDO articleBaseDO);
    /**
     * @author: RenBin
     * @description: 删除指定文章
     * @date: 2020/2/10 18:54
     */
    Long deleteArticle(Long id);
}
