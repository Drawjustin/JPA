package org.example.chapter04.wrongv1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team04wv1 team = new Team04wv1();
            team.setName("TeamA");
            em.persist(team);
            Member04wv1 member = new Member04wv1();
            member.setName("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            Member04wv1 findMember = em.find(Member04wv1.class, member.getId());
            Long findTeamId = findMember.getTeamId();
            Team04wv1 findTeam = em.find(Team04wv1.class, findTeamId);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
