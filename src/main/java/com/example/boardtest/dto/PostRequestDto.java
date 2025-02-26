package com.example.boardtest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Size(min = 3, max = 100, message = "제목은 3자 이상, 100자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력 값입니다.")
    @Size(min = 10, max = 1000, message = "내용은 10자 이상, 1000자 이하여야 합니다.")
    private String content;
}
