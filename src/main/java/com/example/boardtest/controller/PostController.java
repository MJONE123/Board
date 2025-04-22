package com.example.boardtest.controller;

import com.example.boardtest.dto.PostRequestDto;
import com.example.boardtest.dto.PostResponseDto;
import com.example.boardtest.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
@Tag(name = "게시판 API", description = "게시글 생성, 조회, 수정, 삭제 기능을 제공합니다.")
public class PostController {
    private final PostService postService;

    // 게시글 생성
    @PostMapping
    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성합니다.")
    public ResponseEntity<PostResponseDto> createPost(
            @Valid @RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok(postService.createPost(requestDto));
    }

    // 전체 게시글 조회
    @GetMapping
    @Operation(summary = "전체 게시글 조회", description = "저장된 모든 게시글을 조회합니다.")
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // 특정 게시글 조회
    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세 조회", description = "ID를 기반으로 특정 게시글을 조회합니다.")
    public ResponseEntity<PostResponseDto> getPostById(
            @Parameter(description = "게시글 ID", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // 게시글 수정
    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정", description = "기존 게시글을 수정합니다.")
    public ResponseEntity<PostResponseDto> updatePost(
            @Parameter(description = "게시글 ID", example = "1") @PathVariable Long id,
            @Valid @RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok(postService.updatePost(id, requestDto));
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "ID를 기반으로 게시글을 삭제합니다.")
    public ResponseEntity<Void> deletePost(
            @Parameter(description = "게시글 ID", example = "1") @PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
