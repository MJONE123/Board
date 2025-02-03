package com.example.boardtest.controller;

import com.example.boardtest.entity.Posts;
import com.example.boardtest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    // 게시글 생성 (Create)
    @PostMapping
    public Posts createPost(@RequestBody Posts post) {
        return postService.createPost(post);
    }

    // 전체 게시글 조회 (Read - 모든 게시글)
    @GetMapping
    public List<Posts> getAllPosts() {
        return postService.getAllPosts();
    }

    // 특정 게시글 조회 (Read - 단건 조회)
    @GetMapping("/{id}")
    public Optional<Posts> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // 게시글 수정 (Update)
    @PutMapping("/{id}")
    public Posts updatePost(@PathVariable Long id, @RequestBody Posts updatedPost) {
        return postService.updatePost(id, updatedPost);
    }

    // 게시글 삭제 (Delete)
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
