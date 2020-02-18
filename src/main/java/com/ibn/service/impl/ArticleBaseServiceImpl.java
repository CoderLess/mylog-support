package com.ibn.service.impl;

import com.ibn.dao.ArticleBaseDao;
import com.ibn.domain.ArticleBaseDTO;
import com.ibn.entity.ArticleBaseDO;
import com.ibn.service.ArticleBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.service.impl
 * @date ：2020/1/31 17:36
 * @description：文章服务实现
 * @version: 1.0
 */
@Service("articleBaseService")
public class ArticleBaseServiceImpl implements ArticleBaseService {
    @Autowired
    private ArticleBaseDao articleBaseDao;
    @Override
    public List<ArticleBaseDO> queryArticleBaseByDTO(ArticleBaseDTO articleBaseDTO) {
        return articleBaseDao.queryArticleBaseByDTO(articleBaseDTO);
    }

    @Override
    public ArticleBaseDO queryArticleBaseById(Long articleId) {
        return articleBaseDao.queryArticleBaseById(articleId);
    }

    @Override
    public Long saveArticle(ArticleBaseDO articleBaseDO) {
        Long curTime = System.currentTimeMillis();
        if (null == articleBaseDO.getCreateTime()) {
            articleBaseDO.setCreateTime(curTime);
        }
        if (null == articleBaseDO.getAccessTime()) {
            articleBaseDO.setAccessTime(curTime);
        }
        return articleBaseDao.saveArticle(articleBaseDO);
    }

    @Override
    public Long updateArticle(ArticleBaseDO articleBaseDO) {
        return articleBaseDao.updateArticle(articleBaseDO);
    }

    @Override
    public Long deleteArticle(Long id) {
        return articleBaseDao.deleteArticle(id);
    }
}
