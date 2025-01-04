package study.data_jpa.chapter08andchapter09;

public class Explain {
    /*
        새로운 엔티티를 구별하는 방법

        save() 메서드
        - 새로운 엔티티면 저장 (persist)
        - 새로운 엔티티가 아니면 병합 (merge)

        새로운 엔티티를 판단하는 기본 전략
        - 식별자 객체일 때 null로 판단
        - 식별자가 자바 기본 타입일때 0으로 판단

        기본키가 String 이며 'A'라는값을 넣었을때, persist 대신, merge가 발생함!

        데이터에 대한 변경 -> 더티체킹 무조건!
        데이터 저장 -> persist 무조건!


        Specifications(명세)

        SpringDataJPA는 JPA Criteria를 활용해서 이 개념을 사용할 수 있도록 지원
        -> 실무에서 쓰기가 애매

        술어(predicate)
        - 참 또는 거짓으로 평가
        - AND OR 같은 연산자로 조합해서 다양한 검색조건을 쉽게 생성(컴포지트 패턴)

        -> Criteria 가 너무 복잡해서.. 매우 비추천 , QueryDSL 추천!


        QueryByExample

        Team teamA = new Team("TeamA");
        em.persist(teamA);
        Member m1 = new Member("m1", 0, teamA);
        Member m2 = new Member("m2", 0, teamA);
        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();


        //probe
        Member member = new Member("m1");
        Example<Member> example = Example.of(member);
        List<Member> result = memberRepository.findAll(example);

        assertThat(result.get(0).getUsername()).isEqualTo("m1");

        무시하고 싶은 컬럼이 있을떄에는?
        -> ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("age");

        장점 :
        도메인 객체만 같으면,구현 기술에 상관없이 그대로 쓸 수 있다.
        동적쿼리가 편하다


        안쓰는 이유
        -> 아우터 조인이 안됨! 보통 이런기술은 조인에서 문제가 발생하더라~
        -> 중첩 제약조건 안됨

        -> QueryDSL 사용!!



        Projections (가끔 도움이 됨)
        : query의 select 절에 들어갈 데이터

        Entity대신 DTO로 조회하고 싶을때 사용

        오픈 프로젝션 : 엔티티컬럼 전부 갖고와서 컬럼매칭
        클로즈 프로젝션 : 정확하게 매칭된 컬럼만 갖고옴
        클래스 프로젝션 : 프록싱 x 구체적인 객체로 반환됨
        동적 프로젝션 : 제네릭을 이용한 동적으로 타입결정!
        중첩 프로젝션 : 연관된 엔티티까지 갖고올때! -> 두번째부터는 최적화가 안됨

        -> 프로젝션 대상이 Root Entitiy면 jpql 셀렉트절 사용할만하다!

        -> QueryDSL을 사용하자 (이건 신인가?)


        네이티브 쿼리
        : JDBC를 직접쓰거나, JDBC 템플릿, MyBatis 이런것들을 갖고 SQL을 직접 짜는 것!
        -> 가급적 사용하지말자. 정말 어쩔 수 없을때 사용하자


        한계가 너무 많다.
        1. 엔티티와 데이터를 알맞게 매칭해줘야함
        2. 반환 타입이 몇 가지 지원이 안됨
        3. Sort 파라미터도 될때도 있고, 안될때도 있음

        -> 커스텀 레포지토리, 별도의 레포지토리를 쓰자 그냥
        그걸로 처리가안된다! 하면
        네이티브 SQL을 DTO로 조회할때는 JdbcTemplate or myBatis 권장!!!


        유일한 장점 1
        가능 <pagable>


     */
}
