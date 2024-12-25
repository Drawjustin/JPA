package org.example.chapter10;//package org.example.chapter07.correctv1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.chapter10.domain.Member;
import org.example.chapter10.domain.Team;

import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setUsername("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setUsername("teamB");
            em.persist(team2);

            Member member = new Member();
            member.setUsername("HJ");
            member.setAge(10);
            member.changeTeam(team);

            Member member2 = new Member();
            member2.setUsername("HJJ");
            member2.setAge(100);
            member2.changeTeam(team);

            Member member3 = new Member();
            member3.setUsername("HJJJ");
            member3.setAge(1000);
            member3.changeTeam(team2);

            em.persist(member);
            em.persist(member2);
            em.persist(member3);

//            em.flush();
//            em.clear();


            int i = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();
            System.out.println("i = " + i);

            List<Member> resultList = em.createQuery("select m from Member m", Member.class)
                    .getResultList();
            System.out.println("resultList = " + resultList);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
