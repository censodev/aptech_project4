package edu.aptech.sem4.controller;

import edu.aptech.sem4.auth.AuthBasicLoginParams;
import edu.aptech.sem4.auth.AuthRegisterParams;
import edu.aptech.sem4.models.User;
import edu.aptech.sem4.repositories.UserRepository;
import edu.aptech.sem4.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("login")
    public Object login(@RequestBody AuthBasicLoginParams params) {
        return authService.login(params);
    }

    @PostMapping("register")
    public Object register(@RequestBody AuthRegisterParams params) throws Exception {
        var token = authService.register(params);
        if (token == null)
            throw new Exception();
        return token;
    }

    @DeleteMapping("logout")
    public void logout() {
        
    }

    @PutMapping("avatar")
    public User updateAvatar(@RequestParam String avatar, @RequestParam Long id) {
        var u = userRepository.findById(id).orElse(null);
        u.setAvatar(avatar);
        return userRepository.save(u);
    }

    @PutMapping("profile")
    public User updateProfile(@RequestParam String fullName, @RequestParam Long id) {
        var u = userRepository.findById(id).orElse(null);
        u.setFullName(fullName);
        return userRepository.save(u);
    }
}
