//package org.example.chapter04.correctv1;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.example.chapter04.correctv1.domain.Member04cv1;
//import org.example.chapter04.correctv1.domain.Team04cv1;
//
//import java.util.List;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Team04cv1 team = new Team04cv1();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member04cv1 member = new Member04cv1();
//            member.setName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            Member04cv1 findMember = em.find(Member04cv1.class, member.getId());
//
//            List<Member04cv1> members = findMember.getTeam().getMembers();
//            for (Member04cv1 member04cv1 : members) {
//                System.out.println("member04cv1 = " + member04cv1);
//            }
//
//            Team04cv1 findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam);
//
//
//            Team04cv1 newTeam = em.find(Team04cv1.class, 100L);
//            findMember.setTeam(newTeam);
//
//
//
//
//
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//        emf.close();
//
//    }
//}
