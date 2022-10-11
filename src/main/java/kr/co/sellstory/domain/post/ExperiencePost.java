package kr.co.sellstory.domain.post;

import kr.co.sellstory.domain.BaseEntity;
import kr.co.sellstory.dto.expPostDto.ExpPostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
public class ExperiencePost extends BaseEntity {

    @Id @Column(name = "exp_post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: 송경석 유저 완성 되면 다시 연결
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    private String title;
    private String content;
    private String summary;
    private int likes;
    private int count;
    private int requiredPoint;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;


    // 연관 관계 편의 메소드

    // 생성 메소드
    public static ExperiencePost createPost(ExpPostDto expPostDto) {
        ExperiencePost experiencePost = new ExperiencePost();

        experiencePost.content = expPostDto.getContent();
        experiencePost.category = Category.dtoToEntity(expPostDto.getCategoryDto());
        experiencePost.summary = expPostDto.getSummary();
        experiencePost.title = expPostDto.getTitle();

        return experiencePost;
    }

    // 비지니스 로직

}
