package com.fish.mapper;

import com.fish.domain.Article;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface ArticleMapper {

    public Article selectArticle(int id);

    public int insertArticle(Article article);

    public int updateArticle(Article article);

    public int deleteArticle(Integer id);
}
