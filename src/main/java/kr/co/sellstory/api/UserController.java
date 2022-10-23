package kr.co.sellstory.api;

import kr.co.sellstory.domain.user.Role;
import kr.co.sellstory.domain.user.User;
import kr.co.sellstory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {

    private UserRepository userRepository;

}
