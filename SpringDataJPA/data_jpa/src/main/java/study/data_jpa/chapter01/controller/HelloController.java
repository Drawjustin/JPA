package study.data_jpa.chapter01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.data_jpa.chapter01.service.MemberServiceImpl;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final MemberServiceImpl memberService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/member")
    public String member(){
        memberService.insertMember();
        return "member";
    }
}
