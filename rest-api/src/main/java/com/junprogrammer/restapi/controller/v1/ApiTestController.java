package com.junprogrammer.restapi.controller.v1;

import com.junprogrammer.restapi.advice.exception.CUserNotFoundException;
import com.junprogrammer.restapi.entity.User;
import com.junprogrammer.restapi.model.response.CommonResult;
import com.junprogrammer.restapi.model.response.ListResult;
import com.junprogrammer.restapi.model.response.SingleResult;
import com.junprogrammer.restapi.repositroy.UserJpaRepo;
import com.junprogrammer.restapi.service.ResponseService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"3. three"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v3")
public class ApiTestController {

    private final UserJpaRepo userJpaRepo;
    private final ResponseService responseService;

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다. ")
    @GetMapping("/api-users")
    public ListResult<User> findAllUser() {
        // 결과가 여러건인 경우 getListResult 를 이용해서 결과를 반환한다.
        return responseService.getListResult(userJpaRepo.findAll());
    }


    @ApiOperation(value = "회원 단건 조회", notes = ".userId로 조회한다. ")
    @GetMapping(value = "/api-users/{msrl}")
    public SingleResult<User> findUserById(
            @ApiParam(value = "회원 Id", required = true)
            @RequestParam Long msrl) {
        // 결과가 여러건인 경우 getListResult 를 이용해서 결과를 반환한다.
        return responseService.getSingleResult(userJpaRepo.findById(msrl).orElseThrow(CUserNotFoundException::new));
    }

    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
    @PostMapping(value = "/api-user")
    public SingleResult<User> save(@ApiParam(value = "회원아이디", required = true) @RequestParam String uid,
                                   @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다.")
    @PutMapping(value = "/api-user")
    public SingleResult<User> modify(
            @ApiParam(value = "회원번호", required = true) @RequestParam String msrl,
            @ApiParam(value = "회원아이디", required = true) @RequestParam String uid,
            @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @ApiOperation(value = "회원 삭제", notes = "userId로 회원정보를 삭제한다")
    @DeleteMapping(value = "/api-user/{msrl}")
    public CommonResult delete(
            @ApiParam(value = "회원번호", required = true) @PathVariable long msrl) {
        userJpaRepo.deleteById(msrl);
        // 성공 결과 정보만 필요한경우 getSuccessResult()를 이용하여 결과를 출력한다.
        return responseService.getSuccessResult();
    }
}
