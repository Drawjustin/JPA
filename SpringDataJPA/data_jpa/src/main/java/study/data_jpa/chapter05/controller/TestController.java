package study.data_jpa.chapter05.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.data_jpa.chapter04.entity.Member;

@RestController
public class TestController {
    @GetMapping("/test")
    public String testController(){
        return "test";
    }

    @GetMapping("/member")
    public String memberController(){
        Member member = new Member("HJ");
        return member.toString();
    }
}
