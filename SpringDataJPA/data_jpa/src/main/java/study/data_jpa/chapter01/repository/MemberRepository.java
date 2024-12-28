package study.data_jpa.chapter01.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import study.data_jpa.chapter01.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
