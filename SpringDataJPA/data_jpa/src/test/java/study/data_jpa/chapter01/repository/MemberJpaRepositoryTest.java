//package study.data_jpa.chapter01.repository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//import study.data_jpa.chapter01.entity.Member;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@Rollback(false)
//class MemberJpaRepositoryTest {
//
//    @Autowired MemberJpaRepository memberJpaRepository;
//
//    @Test
//    public void testMember(){
//        Member member = new Member("username");
//        Member savedMember = memberJpaRepository.save(member);
//
//        Member findMember = memberJpaRepository.find(savedMember.getId());
//        assertThat(findMember.getId()).isEqualTo(member.getId());
//        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//
//    }
//
//}
