package com.pandahun.baseentitytest.service.dto.article;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleUpdateRequsetDto {

    private Long id;
    private String title;

    public ArticleUpdateRequsetDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
