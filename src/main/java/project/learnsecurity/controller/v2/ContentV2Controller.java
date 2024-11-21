package project.learnsecurity.controller.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.learnsecurity.service.MyUserDetailService;
import project.learnsecurity.webtoken.JwtService;
import project.learnsecurity.webtoken.LoginForm;

@RestController
@RequiredArgsConstructor
public class ContentV2Controller {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MyUserDetailService myUserDetailService;

    @GetMapping("/v2/home")
    public String handleWelcome() {
        return "Welcome to home!";
    }

    @GetMapping("/v2/admin/home")
    public String handleAdminHome() {
        return "Welcome to ADMIN home!";
    }

    @GetMapping("/v2/user/home")
    public String handleUserHome() {
        return "Welcome to USER home!";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.username(), loginForm.password()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
        } else {
            throw new UsernameNotFoundException("Invalid Credentials");
        }
    }
}
