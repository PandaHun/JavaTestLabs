package com.pandahun.baseentitytest.service;

import com.pandahun.baseentitytest.domain.Article;
import com.pandahun.baseentitytest.domain.ArticleRepository;
import com.pandahun.baseentitytest.service.dto.article.ArticleResponseDto;
import com.pandahun.baseentitytest.service.dto.article.ArticleSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long saveArticle(ArticleSaveRequestDto requestDto) {
        Article article = requestDto.toEntity();
        articleRepository.save(article);
        return article.getId();
    }

    public ArticleResponseDto getArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return new ArticleResponseDto(article);
    }

    @Transactional
    public ArticleResponseDto updateArticle(Long id, String title) {
        Article article = articleRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        article.updateTitle(title);
        return new ArticleResponseDto(article);
    }
}
