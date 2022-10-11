package kr.co.sellstory.dto.expPostDto;

import kr.co.sellstory.domain.post.ExperiencePost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ExpPostDto {
    private String title;
    private String content;
    private String summary;

    private CategoryDto categoryDto;

    public static ExpPostDto entityToDto(ExperiencePost experiencePost) {
        return ExpPostDto.builder()
                .categoryDto(CategoryDto.entityToDto(experiencePost.getCategory()))
                .title(experiencePost.getTitle())
                .content(experiencePost.getContent())
                .build();
    }
}
