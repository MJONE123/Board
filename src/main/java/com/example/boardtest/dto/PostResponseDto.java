package com.example.boardtest.dto;

import com.example.boardtest.entity.Posts;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;

    // Entity → DTO 변환
    public PostResponseDto(Posts post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
