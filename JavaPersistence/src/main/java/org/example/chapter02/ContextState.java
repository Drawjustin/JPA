package org.example.chapter02;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.chapter01.Member;

public class ContextState {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hello");

    public static void main(String[] args) {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // 영속 컨텍스트에 넣고, 나중에 보냄 (쓰기 지연)
            Member member0 = new Member(2L, "투명드래곤");
            persistMember(em,member0);
            // 영속 컨텍스트에 있기 때문에, 조회쿼리가 나가지 않음
            findMember(em,1L);

            // 한 트랜잭션 내에서 동일한 객체 보장
            Member member1 = findMember(em,10L);
            Member member2 = findMember(em,10L);
            System.out.println("member2 == member1 = " + (member2 == member1));


            // 쓰기 지연 테스트2
//          <property name="hibernate.jdbc.batch_size" value="10"/>
            Member member3 = new Member(150L, "A");
            Member member4 = new Member(200L, "B");
            persistMember(em,member3);
            persistMember(em,member4);
            System.out.println("엔티티비교======================================");

            // 더티 체킹(Dirty checked)
            // 영속성 컨텍스트의 스냅샷과 현재 상태비교 후 다르면 update 쿼리 저장소에 저장
            member4.setName("ZZZZZ");
            System.out.println("더티체킹======================================");


            // 삭제
            removeMember(em,150L);



        }catch (Exception e){
            tx.rollback();
        }finally {
            tx.commit();
        }



    }

    private static void persistMember(EntityManager em, Member member) {
        System.out.println("=== BEFORE ===");
        em.persist(member);
        System.out.println("=== AFTER ===");
    }

    private static Member findMember(EntityManager em, Long Key) {
        Member member = em.find(Member.class, Key);
        return member;
    }

    private static void removeMember(EntityManager em, long l) {
        em.remove(l);
    }
}
