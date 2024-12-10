package org.example.hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(new Member(1L,"유현종"));
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
        }


        List<Member> result = em.createQuery("select m from Member as m", Member.class)
                .getResultList();

        System.out.println("result = " + result);


        try {
            Member member = em.find(Member.class, 1L);
            System.out.println("member = " + member);
        }catch (Exception e){
            tx.rollback();
        }finally {
        }

        try {
            Member member = em.find(Member.class, 1L);
            member.setName("현종잉");
            System.out.println("member update = " + member);
        }catch (Exception e){
            tx.rollback();
        }finally {
        }

        try {
            Member member = em.find(Member.class, 1L);
            em.remove(member);
            System.out.println("member delete success : " + member);
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();




    }
}
