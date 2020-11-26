package com.pandahun.baseentitytest.service.dto.article;

import com.pandahun.baseentitytest.domain.Article;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleSaveRequestDto {

    @NotEmpty
    private String title;
    @NotEmpty
    private String description;

    public ArticleSaveRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .description(this.description)
                .build();
    }
}
