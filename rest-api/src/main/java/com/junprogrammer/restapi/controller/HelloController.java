package com.junprogrammer.restapi.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /**
     * 화면에 hello world 가 출력
     */
    @GetMapping("/helloworld/string")
    @ResponseBody
    public String helloWorldString() {

        return "helloworld";
    }

    /**
     * 화면에 {message: "helloworld"} 라고 출력
     */
    @GetMapping("/helloworld/json")
    @ResponseBody
    public Hello helloworldJson() {
        Hello hello = new Hello();
        hello.setMessage("helloworld");
        return hello;
    }

    /**
     * 화면에 helloworld.ft1 내용이 출력 :     @ResponseBody 를  표시해주지 않으면 String  에서는
     * 해당결과를 표시해주기 위해 페이지를 찾는데 없으면 에러가 발생
     */
//    @GetMapping("/helloworld/page")
//    public String helloworld() {
//        return ;
//    }

    @Getter
    @Setter
    public class Hello {
        private String message;
    }
}


