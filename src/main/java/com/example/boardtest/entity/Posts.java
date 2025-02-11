package com.example.boardtest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

// @Entity를 보고 JPA가 이 클래스를 테이블과 매핑
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    //DTO를 활용한 생성자 추가 <- 이부분 넣어야하나?
    /*
    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }
    */
}
