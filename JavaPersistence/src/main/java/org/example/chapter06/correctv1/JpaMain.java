//package org.example.chapter06.correctv1;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.example.chapter06.correctv1.domain.Book06cv1;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Book06cv1 book = new Book06cv1();
//            book.setName("JPA");
//            book.setAuthor("김영한");
//
//            em.persist(book);
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
