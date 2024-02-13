package com.study.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;


@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class MemberRequest {

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private Gender gender;
    private LocalDate birthday;

    public void encodingPassword(PasswordEncoder passwordEncoder){
        if(StringUtils.isEmpty(password)){
            return;
        }
        password=passwordEncoder.encode(password);
    }

}
