package com.example.boardtest.service;

import com.example.boardtest.dto.PostRequestDto;
import com.example.boardtest.dto.PostResponseDto;
import com.example.boardtest.entity.Posts;
import com.example.boardtest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 생성 (DTO 사용)
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Posts post = new Posts(requestDto.getTitle(), requestDto.getContent());
        Posts savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost);
    }

    // 전체 게시글 조회 (Entity → DTO 변환)
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    // 특정 게시글 조회 (Entity → DTO 변환)
    public PostResponseDto getPostById(Long id) {
        Posts post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return new PostResponseDto(post);
    }

    // 게시글 수정 (DTO 적용)
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Posts post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
