package study.data_jpa.chapter01.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.data_jpa.chapter01.entity.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insertMember(Member member){
        EntityTransaction tx = em.getTransaction();
        em.persist(member);
        em.flush();
        tx.commit();
    }

}
