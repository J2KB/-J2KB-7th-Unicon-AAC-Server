package kr.co.sellstory.domain.user;

import kr.co.sellstory.domain.BaseEntity;
import kr.co.sellstory.dto.userDto.UserSignupRequestDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Override
    public String toString() {
        return "nickname: " + nickname;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String nickname;

    private String email;

    @Setter
    private String password;
    private String working;
    private String job;
    private int postCount;
    private int purchaseCount;
    private int point;

    private String provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지
    private String providerId;

//    @Enumerated(EnumType.STRING)
//    @Setter
//    private Role role;


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public void update(String nickname) {
        this.nickname = nickname;
    }

    @Builder(builderClassName = "UserDetailRegister", builderMethodName = "userDetailRegister")
    public User(String username, String password, String email, Role role) {
        this.nickname = username;
        this.password = password;
        this.email = email;
//        this.role = role;
    }
    @Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
    public User(String username, String password, String email, Role role, String provider, String providerId) {
        this.nickname = username;
        this.password = password;
        this.email = email;
//        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

}
