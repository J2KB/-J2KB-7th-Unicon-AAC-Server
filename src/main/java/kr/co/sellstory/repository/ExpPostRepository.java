package kr.co.sellstory.repository;

import kr.co.sellstory.domain.post.ExperiencePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpPostRepository extends JpaRepository<ExperiencePost, Long> {

    Optional<ExperiencePost> findById(Long id);
}
