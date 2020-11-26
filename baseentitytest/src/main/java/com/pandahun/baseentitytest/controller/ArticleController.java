package com.pandahun.baseentitytest.controller;

import com.pandahun.baseentitytest.service.ArticleService;
import com.pandahun.baseentitytest.service.dto.article.ArticleResponseDto;
import com.pandahun.baseentitytest.service.dto.article.ArticleSaveRequestDto;
import com.pandahun.baseentitytest.service.dto.article.ArticleUpdateRequsetDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api
@Slf4j
@RequestMapping("/api/")
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/api/v1/articles")
    public Long saveArtice(ArticleSaveRequestDto saveRequestDto) {
        return articleService.saveArticle(saveRequestDto);
    }

    @GetMapping("/api/v1/articles/{id}")
    public ArticleResponseDto getArticle(@PathVariable("id") Long id) {
        return articleService.getArticle(id);
    }

    @PutMapping("/api/v1/articles")
    public ArticleResponseDto updateArticle(ArticleUpdateRequsetDto requsetDto) {
        return articleService.updateArticle(requsetDto.getId(), requsetDto.getTitle());
    }
}
