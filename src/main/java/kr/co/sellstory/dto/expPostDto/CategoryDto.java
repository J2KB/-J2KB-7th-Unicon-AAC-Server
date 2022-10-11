package kr.co.sellstory.dto.expPostDto;

import kr.co.sellstory.domain.post.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;

    public static CategoryDto entityToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
