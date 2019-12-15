package com.educationapp.server.authorization.endpoints;

import java.util.Collections;

import javax.validation.Valid;

import com.educationapp.server.authorization.models.LoginApi;
import com.educationapp.server.authorization.models.RegisterApi;
import com.educationapp.server.authorization.models.UserApi;
import com.educationapp.server.authorization.security.JwtTokenProvider;
import com.educationapp.server.authorization.servises.UserService;
import com.educationapp.server.users.model.domain.User;
import com.educationapp.server.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthEndpoint {

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<UserApi> authenticateUser(@RequestBody @Valid LoginApi loginApi) {
        UserApi user = userService.findByUserName(loginApi.getUsername());

        if (user.getPassword().equals(loginApi.getPassword())) {
            user.setToken(tokenProvider.createToken(loginApi.getUsername(),
                                                    Collections.singletonList(user.getRole().toString())));

            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/signUp")
    public ResponseEntity<LoginApi> register(@RequestBody RegisterApi registerApi) {
        User user = userService.save(registerApi);
        LoginApi loginApi = new LoginApi(user.getUsername(), user.getPassword());

        return new ResponseEntity<>(loginApi, HttpStatus.OK);
    }
}
