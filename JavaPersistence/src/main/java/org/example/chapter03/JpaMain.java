//package org.example.chapter03;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.example.chapter03.domain.Member03;
//import org.example.chapter03.domain.Order03;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//
//            // 뭔가 어색하지 않은가? 객체지향스럽지 못하다!
//            // 참조가 끊김!
//            Order03 order = em.find(Order03.class, 1L);
//            Long memberId = order.getMemberId();
//            Member03 member = em.find(Member03.class, memberId);
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
