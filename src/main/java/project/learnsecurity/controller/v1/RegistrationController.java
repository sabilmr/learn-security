package project.learnsecurity.controller.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.learnsecurity.entity.MyUserEntity;
import project.learnsecurity.repository.MyUserRepository;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final MyUserRepository MyUserRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public MyUserEntity register(@RequestBody MyUserEntity myUserEntity) {
        myUserEntity.setPassword(passwordEncoder.encode(myUserEntity.getPassword()));
        return MyUserRepository.save(myUserEntity);
    }
}
