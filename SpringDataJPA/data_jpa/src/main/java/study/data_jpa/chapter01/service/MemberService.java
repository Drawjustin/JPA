package study.data_jpa.chapter01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.data_jpa.chapter01.entity.Member;
import study.data_jpa.chapter01.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Member member){
        memberRepository.insertMember(member);
        return member;
    }


}
