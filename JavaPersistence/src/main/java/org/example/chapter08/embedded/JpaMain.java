//package org.example.chapter08.embedded;//package org.example.chapter07.correctv1;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.example.chapter08.embedded.domain.Member08em;
//import org.example.chapter08.embedded.domain.Period06do;
//
//import java.time.LocalDateTime;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Member08em member = new Member08em();
//            member.setUsername("hello");
//            member.setPeriod(new Period06do(LocalDateTime.now(),LocalDateTime.now()));
//            em.persist(member);
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
