package com.example.boardtest.service;

import com.example.boardtest.entity.Posts;
import com.example.boardtest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 생성
    public Posts createPost(Posts post) {
        return postRepository.save(post);
    }

    // 게시글 전체 조회
    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }

    // 게시글 단건 조회
    public Optional<Posts> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 게시글 수정
    public Posts updatePost(Long id, Posts updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    return postRepository.save(post);
                }).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }

    // 5️⃣ 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
