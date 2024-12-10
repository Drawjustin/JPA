package org.example.chapter02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.chapter01.Member;

public class NotPersistenceState {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hello");

    public static void main(String[] args) {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // 영속 상태로 전환
            Member member = findMember(em, 1L);
            member.setName("AAAAA");

            // 준영속 상태로 만드는 방법1
            //em.detach(member);

            // 준영속 상태로 만드는 방법2
            //em.clear();
            Member member2 = findMember(em, 1L);

            // 준영속 상태로 만드는 방법3
            em.close();
            Member member3 = findMember(em, 1L);


            System.out.println("===============================");
        }catch (Exception e){
            tx.rollback();
        }finally {
            tx.commit();
            em.close();
        }
        entityManagerFactory.close();

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
