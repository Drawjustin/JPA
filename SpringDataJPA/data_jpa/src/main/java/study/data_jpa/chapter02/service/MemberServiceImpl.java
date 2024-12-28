package study.data_jpa.chapter02.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.data_jpa.chapter02.entity.Member;
import study.data_jpa.chapter02.repository.MemberJpaRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl {
    private final MemberJpaRepository memberJpaRepository;

    public void insertMember() {
        Member member = new Member("HJ");
        memberJpaRepository.save(member);
    }
}

