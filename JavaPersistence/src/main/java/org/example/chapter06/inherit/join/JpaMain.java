//package org.example.chapter06.inherit.join;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.example.chapter06.inherit.join.domian.Movie06join;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//            Movie06join movie = new Movie06join();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("신과함께");
//            movie.setPrice(10000);
//
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie06join findMovie = em.find(Movie06join.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
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
