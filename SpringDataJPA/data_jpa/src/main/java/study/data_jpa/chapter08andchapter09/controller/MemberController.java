package study.data_jpa.chapter08andchapter09.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.data_jpa.chapter08andchapter09.dto.MemberDto;
import study.data_jpa.chapter08andchapter09.entity.Member;
import study.data_jpa.chapter08andchapter09.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member){
        return member.getUsername();
    }
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 5) @Qualifier("member123") Pageable memberPageable){
        Page<Member> page = memberRepository.findAll(memberPageable);
//        return page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));
        return page.map(MemberDto::new);
    }

//    @PostConstruct
//    public void init(){
//        for (int i = 0; i < 100; i++) {
//            memberRepository.save(new Member("user" + i, i));
//        }
//    }
}
