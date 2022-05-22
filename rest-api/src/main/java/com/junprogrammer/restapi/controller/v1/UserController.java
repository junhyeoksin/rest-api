package com.junprogrammer.restapi.controller.v1;

import com.junprogrammer.restapi.entity.User;
import com.junprogrammer.restapi.repositroy.UserJpaRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@RequiredArgsConstructor  // 생성자 주입
//@RestController
//@RequestMapping(value = "/v1")
//public class UserController {
//
//    private final UserJpaRepo userJpaRepo;
//
//    @GetMapping("/user")
//    public List<User> findAllUser(){
//
//        return userJpaRepo.findAll();
//    }
//    @PostMapping("/user")
//    public User save(){
//        User user = User.builder()
//                .uid("test@naverr.com")
//                .name("jun")
//                .build();
//        return userJpaRepo.save(user);
//    }
//}

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private final UserJpaRepo userJpaRepo;

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userJpaRepo.findAll();
    }

    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
    @PostMapping(value = "/user")
    public User save(@ApiParam(value = "회원아이디", required = true) @RequestParam String uid,
                     @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .uid(uid)
                .name(name)
                .build();
        return userJpaRepo.save(user);
    }
}