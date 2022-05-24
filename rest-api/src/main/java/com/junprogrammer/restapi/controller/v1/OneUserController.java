package com.junprogrammer.restapi.controller.v1;

import com.junprogrammer.restapi.entity.User;
import com.junprogrammer.restapi.repositroy.UserJpaRepo;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class OneUserController {

    private final UserJpaRepo userJpaRepo;

    @GetMapping(value = "/version-user")
    public List<User> findAllUser(){

        return userJpaRepo.findAll();
    }
    @PostMapping(value = "/version-user")
    public User save(){
        User user = User.builder()
                .uid("test@naverr.com")
                .name("jun")
                .build();
        return userJpaRepo.save(user);
    }
}
