package com.pandahun.baseentitytest.service.dto.article;

import com.pandahun.baseentitytest.domain.Article;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ArticleResponseDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.description = article.getDescription();
        this.createAt = article.getCreatedDate();
        this.modifiedAt = article.getLastModifiedDate();
    }
}
