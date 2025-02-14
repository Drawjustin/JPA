//package study.data_jpa.chapter01.repository;
//
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import study.data_jpa.chapter01.entity.Member;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@Rollback(false)
//class MemberRepositoryTest {
//
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    public void testMember(){
//        Member member = new Member("MemberA");
//        Member savedMember = memberRepository.save(member);
//        Member findMember = memberRepository.findById(savedMember.getId()).get();
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        assertThat(findMember).isEqualTo(member);
//    }
//}