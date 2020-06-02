package com.fish.yunpingtai;

import com.fish.domain.Article;
import com.fish.mapper.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YunpingtaiApplicationTests {

//    @Autowired
//    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {
    }
//
//    @Test
//    public void selectComment(){
//        Comment comment = commentMapper.findById(1);
//        System.out.println(comment);
//    }

    @Test
    public void selectArticle(){
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

}
