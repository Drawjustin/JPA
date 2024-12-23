package org.example.chapter09;//package org.example.chapter07.correctv1;

import jakarta.persistence.*;
import org.example.chapter09.domain.Member;
import org.example.chapter09.domain.Team;
import org.example.chapter09.dto.MemberDTO;

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

            Member member = new Member();
            member.setUsername("HJ");
            member.setAge(10);

            member.changeTeam(team);

            em.persist(member);



            em.flush();
            em.clear();

            List<Member> result = em.createQuery("select m from Member m, Team t where m.username = t.username", Member.class)
                    .getResultList();


//            List<MemberDTO> result = em.createQuery("select new org.example.chapter09.dto.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

//            List<Member> resultList = query.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            String singleResult = em.createQuery("select m.username from Member m where m.username = :username", String.class)
//                    .setParameter("username", "HJ")
//                    .getSingleResult();
//            System.out.println("singleResult = " + singleResult);
//
//            Query query3 = em.createQuery("select m.username, m.age from Member m where m.age = 10");



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
