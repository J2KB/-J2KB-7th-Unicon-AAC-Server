package kr.co.sellstory.api;

import kr.co.sellstory.dto.expPostDto.ExpPostDto;
import kr.co.sellstory.service.ExpPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ExpPostController {

    private final ExpPostService expPostService;

    @PostMapping(value = "/v1/experience")
    public void create(@RequestBody ExpPostDto expPostDto) {
        expPostService.save(expPostDto);
    }

    @GetMapping(value = "/v1/experience")
    public ExpPostDto getQuiz(@RequestParam(name = "id") Long id) {
        return expPostService.getExpPost(id);
    }
}
