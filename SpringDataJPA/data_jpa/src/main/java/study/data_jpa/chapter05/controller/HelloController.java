package study.data_jpa.chapter05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.data_jpa.chapter05.service.MemberServiceImpl;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final MemberServiceImpl memberService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
