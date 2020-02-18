package com.ibn.controller;

import com.ibn.base.entity.ResultInfo;
import com.ibn.domain.ArticleBaseDTO;
import com.ibn.entity.ArticleBaseDO;
import com.ibn.service.ArticleBaseService;
import com.ibn.util.BeanUtil;
import com.ibn.vo.ArticleBaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：RenBin
 * @projectName: mylog-support
 * @packageName：com.ibn.controller
 * @date ：2020/1/31 17:06
 * @description：文章标题
 * @version: 1.0
 */
@RestController
@RequestMapping(path = "articles")
public class ArticleBaseController {
    @Autowired
    private ArticleBaseService articleBaseService;

    /**
     * @author: RenBin
     * @description: 获取指定目录下的所有文章信息
     * @date: 2020/1/31 17:11
     */
    @RequestMapping(method = RequestMethod.GET, path = "list/{id}")
    public ResultInfo<Object> getArticleList(@PathVariable("id") Long id, HttpServletRequest request) {
        if (id == null) {
            return new ResultInfo<>().error("参数不合法");
        }
        ArticleBaseDTO articleBaseDTO = new ArticleBaseDTO();
        articleBaseDTO.setMenuId(id);
        List<ArticleBaseDO> articleBaseDOList = articleBaseService.queryArticleBaseByDTO(articleBaseDTO);
        return new ResultInfo<>().response(articleBaseDOList);
    }

    /**
     * @author: RenBin
     * @description: 获取指定文章的详细信息
     * @date: 2020/2/1 11:47
     */
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResultInfo<Object> getArticle(@PathVariable("id") Long id, HttpServletRequest request) {
        if (id == null) {
            return new ResultInfo<>().error("参数不合法");
        }
        ArticleBaseDO articleBaseDOList = articleBaseService.queryArticleBaseById(id);
        return new ResultInfo<>().response(articleBaseDOList);
    }

    /**
     * @author: RenBin
     * @description: 保存文章相关信息
     * @date: 2020/2/6 07:35
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResultInfo<Object> saveArticle(@RequestBody ArticleBaseVO articleBaseVO) {
        if (articleBaseVO == null) {
            return new ResultInfo<>().error("参数不合法");
        }
        ArticleBaseDO articleBaseDO = new ArticleBaseDO();
        BeanUtil.copyProperties(articleBaseVO, articleBaseDO);
        if (null != articleBaseVO.getId() && !Long.valueOf(0L).equals(articleBaseVO.getId())) {
            // 如果有id则是编辑操作，进行更新
            articleBaseService.updateArticle(articleBaseDO);
        } else {
            // 如果没有id则进行更新操作
            articleBaseService.saveArticle(articleBaseDO);
        }
        return new ResultInfo<>().success("添加成功");
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResultInfo<Object> deleteArticle(@PathVariable("id") Long id, HttpServletRequest request) {
        if (id == null) {
            return new ResultInfo<>().error("参数不合法");
        }
        articleBaseService.deleteArticle(id);
        return new ResultInfo<>().success("删除成功");
    }
}
