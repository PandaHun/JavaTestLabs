package com.pandahun.baseentitytest;

import com.pandahun.baseentitytest.domain.Article;
import com.pandahun.baseentitytest.domain.ArticleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void saveTest() {
        LocalDateTime now = LocalDateTime.now();
        articleRepository.save(Article.builder()
                .title("제목")
                .description("내용")
                .build());
        List<Article> articles = articleRepository.findAll();
        Article article = articles.get(0);
        Assertions.assertTrue(article.getCreatedDate().isAfter(now));
        article.updateTitle("수정");
        articleRepository.save(article);
        Assertions.assertTrue(article.getCreatedDate().isAfter(article.getLastModifiedDate()));
    }
}
