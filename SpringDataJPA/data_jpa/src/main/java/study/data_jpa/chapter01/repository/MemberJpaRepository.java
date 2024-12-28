//package study.data_jpa.chapter01.repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//import study.data_jpa.chapter01.entity.Member;
//
//@Repository
//@Transactional
//public class MemberJpaRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//
//    public Member save(Member member){
//        em.persist(member);
//        return member;
//    }
//
//    public Member find(Long id){
//        return em.find(Member.class,id);
//    }
//
//}
