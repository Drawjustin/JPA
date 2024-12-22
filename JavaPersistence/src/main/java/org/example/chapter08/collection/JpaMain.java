package org.example.chapter08.collection;//package org.example.chapter07.correctv1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.chapter08.collection.domain.Member08col;
import org.example.chapter08.collection.domain.Period06col;

import java.time.LocalDateTime;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member08col member = new Member08col();
            member.setUsername("member1");
            member.setPeriod(new Period06col(LocalDateTime.now(),LocalDateTime.now()));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("햄버거");

            member.getPeriodHistory().add(new Period06col(LocalDateTime.now(),LocalDateTime.now()));
            member.getPeriodHistory().add(new Period06col(LocalDateTime.of(1,3,4,5,6),LocalDateTime.of(1,3,4,5,6)));


            em.persist(member);
            em.flush();
            em.clear();

            System.out.println("================START===========================================");
            Member08col findmember = em.find(Member08col.class, member.getId());

            Period06col a = findmember.getPeriod();
            findmember.setPeriod06col(new Period06col(a.getStartDate(),LocalDateTime.now()));

            //치킨 -> 한식
            findmember.getFavoriteFoods().remove("치킨");
            findmember.getFavoriteFoods().add("한식");

            findmember.getPeriodHistory().remove(new Period06col(LocalDateTime.of(1,3,4,5,6),LocalDateTime.of(1,3,4,5,6)));
            findmember.getPeriodHistory().add(new Period06col(LocalDateTime.now(),LocalDateTime.now()));

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
