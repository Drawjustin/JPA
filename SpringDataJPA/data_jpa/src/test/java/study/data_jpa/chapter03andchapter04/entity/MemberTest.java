package study.data_jpa.chapter03andchapter04.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import study.data_jpa.chapter02.entity.Member;
import study.data_jpa.chapter02.entity.Team;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {
    @PersistenceContext
    EntityManager em;

    @Test
    public void testEntity(){
        study.data_jpa.chapter02.entity.Team teamA = new study.data_jpa.chapter02.entity.Team("teamA");
        study.data_jpa.chapter02.entity.Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        study.data_jpa.chapter02.entity.Member member1 = new study.data_jpa.chapter02.entity.Member("member1",10,teamA);
        study.data_jpa.chapter02.entity.Member member2 = new study.data_jpa.chapter02.entity.Member("member2",20,teamA);
        study.data_jpa.chapter02.entity.Member member3 = new study.data_jpa.chapter02.entity.Member("member3",30,teamB);
        study.data_jpa.chapter02.entity.Member member4 = new study.data_jpa.chapter02.entity.Member("member4",40,teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        //초기화
        em.flush();
        em.clear();
        
        //확인
        List<study.data_jpa.chapter02.entity.Member> members = em.createQuery("select m from Member m", study.data_jpa.chapter02.entity.Member.class).getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam() = " + member.getTeam());
        }

    }


}