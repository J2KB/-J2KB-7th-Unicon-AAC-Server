package kr.co.sellstory.service;

import kr.co.sellstory.domain.post.ExperiencePost;
import kr.co.sellstory.dto.expPostDto.ExpPostDto;
import kr.co.sellstory.repository.ExpPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExpPostService {

    private final ExpPostRepository expPostRepository;

    @Transactional
    public ExpPostDto save(ExpPostDto expPostDto) {
        ExperiencePost savedExperiencePost = expPostRepository.save(ExperiencePost.createPost(expPostDto));
        return ExpPostDto.entityToDto(savedExperiencePost);
    }

    public ExpPostDto getQuiz(Long id) {
        ExperiencePost findExperiencePost = expPostRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ExpPostDto.entityToDto(findExperiencePost);
    }
}
