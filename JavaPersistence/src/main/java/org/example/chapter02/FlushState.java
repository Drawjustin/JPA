package org.example.chapter02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.chapter01.Member;

public class FlushState {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hello");

    public static void main(String[] args) {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // 쓰기 지연 저장소에 있는 쿼리를 DB에 보내는 작업 = flush
            // 영속성 컨텍스트를 비우는 작업이 아님, 영속성 컨텍스트의 변경내용을 DB에 동기화
            // flush 호출시에 update 쿼리가 생김!
            // commit 된게 아님, rollback 가능!
            // JPQL 쿼리 실행시 플러시가 자동으로 실행됨
            Member member = new Member(2L, "투명드래곤");
            em.flush();

        }catch (Exception e){
            tx.rollback();
        }finally {
            tx.commit();
        }



    }

    private static void persistMember(EntityManager em, Member member) {
        System.out.println("=== BEFORE ===");
        em.persist(member);
        System.out.println("=== AFTER ===");
    }

    private static Member findMember(EntityManager em, Long Key) {
        Member member = em.find(Member.class, Key);
        return member;
    }

    private static void removeMember(EntityManager em, long l) {
        em.remove(l);
    }
}
