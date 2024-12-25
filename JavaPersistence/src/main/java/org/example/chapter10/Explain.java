package org.example.chapter10;

public class Explain {
    /*
    객체지향 쿼리 언어 - 중급 문법

    경로 표현식
    -> .(점)을 찍어 객체 그래프를 탐색하는 것
    select m.username -> 상태필드
     from Member m
      join m.team t -> 단일 값 연관 필드
      join m.orders o -> 컬렉션 값 연관 필드
    where t.name = '팀A'

    상태 필드 : 단순히 값을 저장하기 위한 필드

    연관 필드(association field) : 연관관계를 위한 필드
    1. 단일 값 연관 필드
    -> @ManyToOne, @OneToOne, 대상이 엔티티(ex: m.team)
    2. 컬렉션 값 연관 필드
    -> @OneToMany, @ManyToMany, 대상이 컬렉션(ex: m.orders)

    경로 표현식 특징

    상태 필드 : 경로 탐색의 끝, 탐색X

    *주의*
  **단일 값 연관 경로 : 묵시적 내부 조인(inner join) 발생, 탐색O**
    -> 웬만하면 묵시적 내부 조인이 발생하게 짜지마라.(튜닝하기 어렵다, 하눈ㄴ에 알아보기 어렵다.등)

    컬렉션 값 연관 경로 : 묵시적 내부 조인 발생 X
    -> FROM 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통해 탐색 가능

    김영한피셜)
    결론 : 실무에서 묵시적 조인 쓰지마라!! 명시적 조인으로 구성하자

****************************패치조인****************************

    페치 조인(fetch join)
    - SQL 조인 종류X
    - JPQL에서 성능 최적화를 위해 제공하는 기능
    - 연관된 엔티티나 컬렉션을 SQL 한 번에 함께 조회하는 기능
    - join fetch 명령어 사용
    - 페치 조인 ::= [LEFT[OUTER]|INNER]JOIN FETCH 조인경로

    ex) 회원을 조회하면서 연관된 팀도 함께 조회(SQL 한 번에)
    SQL을 보면 회원 뿐만 아니라 팀(T.*)도 함께 SELECT
    [JPQL]
    SELECT m from Member m join fetch m.team

    [SQL]
    SELECT M.*,T.* FROM Member M
    INNER JOIN TEAM T ON M.TEAM_ID=T.ID


    // 쿼리가 N+1개 나감!
    List<Member> result = em.createQuery("select m from Member m", Member.class)
        .getResultList();

    for (Member member1 : result) {
        System.out.println("member1.getTeam() = " + member1.getTeam());
    }


    // 쿼리가 한번에 나감!
    List<Member> fetchResult = em.createQuery("select m from Member m join fetch m.team", Member.class)
            .getResultList();

    for (Member member1 : fetchResult) {
        System.out.println("member1.getTeam() = " + member1.getTeam());
    }

    SQL의 DISTINCT는 중복된 결과를 제거하는 명령
    **하이버네이트6 변경사항에서 명령어를 사용하지 않아도 애플리케이션에서 중복 제거가 자동으로 적용된다**
    JQPL의 DISTINCT 2가지 기능 제공
    1. SQL에 DISTINCT를 추가
    2. 애플리케이션에서 엔티티 중복 제거

    페치 조인과 일반 조인의 차이
    -> 일반 조인 실행시 연관된 엔티티를 함께 조회하지 않음

    **즉 페치 조인 -> 즉시로딩**

    페치 조인의 특징과 한계

    *페치 조인 대상에는 별칭을 줄 수 없다*
    - 하이버네이트는 가능, 가급적 사용 XX
    - 둘 이상의 컬렉션은 페치 조인 할 수 없다.
    - 컬렉션을 페치 조인 하면 페이징 API(SetFirstResult,setMaxResults)를 사용할 수 없다.
      - 일대일, 다대일 같은 단일 값 연관 필드들은 페치 조인해도 페이징 가능
      - 하이버네이트는 경고 로그를 남기고 메모리에서 페이징(매우 위험)
    그럼 어떻게하냐?
    --> 다대일은 상관없음!
    --> 또는 Fetch join 없애고, @BatchSize(100)를 활용함
    globalSetting -> <property name = "hibernate.default_batch_fetch_size value" = "100"/>
    --> New Operation을 사용하여 DTO로 뽑는다.

    정리

    모든 것을 페치 조인으로 해결할 수는 없음
    페치 조인은 객체 그래프를 유지할 때 사용하면 효과적

    복잡한 통계쿼리 -> 일반조인 + DTO 반환

    최적의 선택 기준
    즉시 로딩이 필요한 경우 → 페치 조인

    데이터를 즉시 사용해야 하며, 페이징이 필요 없고 데이터 크기가 작다면 페치 조인이 적합합니다.
    지연 로딩 및 페이징이 필요한 경우 → 배치 사이즈

    데이터 크기가 크거나 여러 컬렉션을 로드해야 하고 페이징이 필요하다면 배치 사이즈를 사용하세요.



    TYPE

    조회 대상을 특정 자식으롷 ㅏㄴ정
    예) Item 중에 Book, Movie를 조회해라

    [JQPL]
    select i from Item i
    where type(i) IN (Book,Movie)

    [SQL]
    select i from i
    where i.DTYPE in ('B','M')

    TREAT(JPA 2.1)
    자바의 타입 캐스팅과 유사
    상속 구조에서 부모 타입을 특정 자식 타입으로 다룰 때 사용
    FROM, WHERE, SELECT(하이버네이트 지원) 사용

    [JQPL]
    select i from Item i
    where treat(i as Book).author = 'kim'

    [SQL]
    select i.* from Item i
    where i.DTYPE = 'B' and i.author = 'kim'


    엔티티 직접 사용 - 기본 키 값
    - JQPL에서 엔티티를 직접 사용하면 SQL에서 해당 엔티티의 기본 키 값을 사용

    [JPQL]
    select count(m.id) from Member m // 엔티티의 아이디 사용
    select count(m) from Member m // 엔티티 직접 사용

    [SQL] (JQPL 둘다 같은 다음 SQL 실행)
    select count(m.id) as cnt from Member m

    엔티티 직접 사용 - 외래 키 값
    - 똗같이 사용하면 된다..
    String jpql = "select m from Member m where m.team = :team";
    List<Member> members = em.createQuery(jpql, Member.class)
            .setParameter("team",team)
            .getResultList();
    System.out.println("members = " + members);


    Named 쿼리 - 어노테이션

    - 미리 정의해서 이름을 부여해두고 사용하는 JPQL
    - 정적 쿼리
    - 어노테이션, XML에 정의(xml이 우선권)
    - 어플리케이션 로딩 시점에 초기화 후 재사용(캐시를 이용하여 재사용할때 이점이 높다!)
    - 어플리케이션 로딩 시점에 쿼리를 검증

    벌크 연산
    - 재고가 10개 미만인 모든 상품의 가격을 10% 상승하려면?
    - JPA 변경 감지 기능으로 실행하려면 너무 많은 SQL 실행
        1. 재고가 10개 미만인 상품을 리스트를 조회한다
        2. 상품 엔티티의 가격을 10% 증가한다.
        3. 트랜잭션 커밋 시점에 변경감지가 동작한다.
    - 변경된 데이터가 100건이라면 100번의 UPDATE SQL 실행

    예시)
    int i = em.createQuery("update Member m set m.age = 20")
            .executeUpdate();
    System.out.println("i = " + i);

    UPDATE, DELETE 지원
    INSERT(하이버네이트 지원)

    **주의**
    - 벌크 연산은 영속성 컨텍스트를 무시하고 데이터베이스에 직접 쿼리
    -> 벌크 연산을 먼저 실행
    -> 벌크 연산 수행 후 영속성 컨텍스트 초기화

    TIP!! : JPQL의 경우 영속성 컨텍스트를 먼저 접근한 후 DB에 접근하여 결과가 다를 수 있음

    (JQPL) 결과 : 기존 값
    int i = em.createQuery("update Member m set m.age = 20")
            .executeUpdate();
    System.out.println("i = " + i);

    List<Member> resultList = em.createQuery("select m from Member m", Member.class)
            .getResultList();
    System.out.println("resultList = " + resultList);



















    */
}
