package org.example.chapter09;

public class Explain {
     /*
        객체지향 쿼리 언어

        JPA는 다양한 쿼리 방법을 지원한다.

        1. JPQL(대부분의 문제 해결가능)
        2. JPA Criteria
        3. QueryDSL
        4. 네이티브 SQL (표준 문법으로 안될때)
        5. JDBC API 직접사용, MyBatis, SpringJdbcTemplate 함께 사용 (표준 문법으로 안될때)


        1. JPQL
        가장 단순한 조회 방법
        EntityManager.find()
        JPA를 사용하면 엔티티 객체를 중심으로 개발

        문제는 검색 쿼리
        검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색

        모든 DB 데이터를 객체로 변환해서 검색하는것은 불가능
        -> 검색 조건이 포함된 SQL이 필요


        JPQL : SQL을 추상화한 JPQL이라는 객체지향 쿼리 언어
        -> 엔티티 객체를 대상으로 쿼리
        SQL은 데이터 베이스 테이블을 대상으로 쿼리

        List<Member08col> resultList = em.createQuery(
                "select m from Member08col m where m.username like '%kim%'",
                Member08col.class
        ).getResultList();

        ****SQL을 추상화해서 특정 데이터 베이스 SQL에 의존하지 않는다****
        -> 한마디로 객체 지향 SQL

        문제점 : 동적 쿼리 작성이 어려움

        지나가는 Tip : 아이바티스, 마이바티스는 동적쿼리를 짜기 쉽다.


        2. JPA Criteria
        자바에서 제공하는 표준..이긴함!

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member08col> query = cb.createQuery(Member08col.class);
        Root<Member08col> m = query.from(Member08col.class);
        query.select(m).where(cb.equal(m.get("username"),"kim"));
        List<Member08col> resultList = em.createQuery(query).getResultList();

        특징
        문자가 아닌 자바코드로 JPQL을 작성할 수 있음
        JPQL 빌더 역할
        JPA 공식기능

        장점 : 컴파일 단계에서 오류를 찾을 수 있음(오타)
              동적 쿼리를 만들기 쉬움!
        단점 : 어렵다..
              SQL스럽지 않다.

        김영한피셜) 실무에서 안쓴다!!, 한눈에 알아보기 어려워서 유지 보수가 어렵더라
        -> QueryDSL 추천!!!!강추!!!!


        3. QueryDSL

        특징
        문자가 아닌 자바코드로 JPQL을 작성할 수 있음
        JPQL 빌더 역할
        컴파일 시점에 문법 오류를 찾을 수 있음
        동적 쿼리 작성 편리함
        단순하고 쉬움
        -> 김영한 피셜) 실무사용권장!!!!


        장점 : SQL이랑 비슷하게 생겨서 한눈에 알아보기 쉽다.
              동적 쿼리 작성이 쉽다.

        단점 : 초기 세팅이 어렵다


        4. 네이티브 SQL (표준 문법으로 안될때)

        JPA가 제공하는 SQL을 직접 사용하는 기능
        JPQL로 해결할 수 없는 특정 데이터베이스에 의존적인 기능
        예) 오라클 CONNECT BY, 특정 DB만 사용하는 SQL 힌트


        5. JDBC API 직접사용, MyBatis, SpringJdbcTemplate 함께 사용 (표준 문법으로 안될때)

        JPA를 사용하면서 JDBC 커넥션을 직접 사용하거나, 스프링 JdbcTemplate, 마이바티스등을 함께 사용 가능
        단 영속성 컨텍스트를 적절한 시점에 강제로 플러시 필요
        예) JPA를 우회해서 SQL을 실행하기 직전에 영속성 컨텍스트 수동 플러시


        Tip : Order <- 예약어이기 때문에 테이블이름 ORDERS 관례




        JPQL(Java Persistence Query Language)

        Tip) 벌크 연산 : 쿼리 한 방으로 한 번에 몇 백만 건 업데이트 치는 것과같은 대량의 데이터 처리 연산

        JPQL 문법

        select m from Member as m where m.age > 18
        엔티티의 속성은 대소문자 구분O (Member, age)
        JPQL 키워드는 대소문자 구분X (SELECT, FROM ,WHERE)
        엔티티 이름 사용, 테이블 이름 아님(Member)

        if) 클래스이름이 같으면요? -> 클래스 이름을 바꾸자!

        ****별칭은 필수(m) (as는 생략가능)****

        TypeQuery : 반환 타입이 명확할 때 사용
        Query : 반환 타입이 명확하지 않을 때 사용

        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
        TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
        Query query3 = em.createQuery("select m.username, m.age from Member m");


        **결과 조회 API**

        *주의*
        query.getResultList() : 결과가 하나 이상일때, 리스트 반환
        -> 결과가 없으면 빈 리스트 반환

        query.getSingleResult() : 결과가 정확히 하나 일때, 단일 객체 반환
        -> 결과가 없으면 NoResultException
        -> 둘 이상이면 NonUniqueResultException

        try catch 하기 좀 거시기하다.
        --> Spring Data JPA -> 결과가 없으면 null
        --> 또는 Optional로 반환

        TypedQuery<String> query2 = em.createQuery("select m.username from Member m where m.username = :username", String.class);
        query2.setParameter("username", "HJ");
        String singleResult = query2.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        -> 보통 이렇게 안쓰고 메소드 체인으로 엮어서 쓴다.

        *파라미터 바인딩*
        1. 이름 기준
        -> 이게 정석!! 이게좋다

        2. 위치 기준
        -> 위치 기준은 중간에 뭐 하나 끼워버리면 순서가 밀려서 비추!!!




        **프로젝션**
        -> SELECT 절에 조회할 대상을 지정하는 것
        프로젝션 대상 : 엔티티, 임베디드 타입, 스칼라 타입(숫자, 문자등 기본 데이터 타입)

        SELECT m FROM Member m -> 엔티티 프로젝션 (결과는 영속성 컨텍스트에서 전부 관리됨)

        SELECT m.team FROM Member m -> 엔티티 프로젝션 (결과는 영속성 컨텍스트에서 전부 관리됨)
        아래는 둘다 같은 결과를 내지만, 조인의 경우 명시적으로 나타내는게 좋다. (결과를 예측할 수 있어야됨)
        -> em.createQuery("select m.team from Member m", Team.class).getResultList();
        -> em.createQuery("select m.team from Member m join m.team t", Team.class).getResultList();

        SELECT m.address FROM Member m -> 임베디드 타입 프로젝션
        -> em.createQuery("select o.address from Order o", Team.class).getResultList();

        SELECT m.username, m.age FROM Member m -> 스칼라 타입 프로젝션
        -> em.createQuery("select m.username, m.age from Member m").getResultList();
        어.. 어떻게 가져와야하지? 응답타입이 두개인데??
        총 3가지 방법으로 조회할 수 있다.

        1. Query 타입
        List resultList = em.createQuery("select distinct m.username, m.age from Member m").getResultList();
        Object o = resultList.get(0);
        Object[] result = (Object[]) o;
        System.out.println("username = " + result[0]);
        System.out.println("age = " + result[1]);

        2. Generic에 선언해버리기
        List<Object[]> resultList = em.createQuery("select distinct m.username, m.age from Member m").getResultList();
        Object[] result = (Object[]) resultList.get(0);
        System.out.println("username = " + result[0]);
        System.out.println("age = " + result[1]);

        3. new 명령어로 조회

        public class MemberDTO {
            private String username;
            private int age;
        }

        List<MemberDTO> result = em.createQuery("select new org.example.chapter09.dto.MemberDTO(m.username, m.age) from Member m", MemberDTO.class).getResultList();
        MemberDTO memberDTO = result.get(0);
        System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
        System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

        -> 패키지가 긴것빼고는 괜찮다. 그러나 QueryDSL 쓰면 다 극복가능!
        -> 순서가 일치하는 생성자 필요


        DISTINCI로 중복 제거
        -> em.createQuery("select distinct m.username, m.age from Member m").getResultList();




        페이징 API

        JPA는 페이징을 다음 두 API로 추상화

        setFirstResult(int startPosition) : 조회 시작 위치
        (0부터 시작)

        setMaxResults(int maxResult) : 조회할 데이터 수

        List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
                                .setFirstResult(1)
                                .setMaxResults(10)
                                .getResultList();
        System.out.println("result.size() = " + result.size());
        System.out.println("result = " + result);


        **조인**
        조인의 경우 3가지경우가 존재한다.

        1. 내부 조인
        -> SELECT m FROM Member m [INNER] JOIN m.team t
        팀이 없으면 결과 X

        2. 외부 조인
        -> SELECT m FROM Member m LEFT [OUTER] JOIN m.team t
        팀이 없으면 NULL로 채워서 반환

        3. 세타 조인
        -> SELECT count(m) from Member m, Team t where m.username = t.name
        카르테시안 곱.. 연관관계가 없는 거를 비교해보고 싶을때 쓴다


        *조인 - ON 절 (JPA 2.1 버전 이상부터 가능!)*

        1. 조인 대상 필터링
        -> 회원과 팀을 조인하면서, 팀 이름이 A인 팀만 조인

        JPQL:
        SELECT m,t FROM Member m LEFT JOIN m.team t on t.name = 'A'

        SQL:
        SELECT m.*,t.* FROM
        Member m LEFT JOIN Team t ON m.TEAM_ID=t.id and t.name='A'


        2. 연관관계 없는 엔티티 외부 조인(하이버네이트 5.1부터)

        JPQL:
        SELECT m,t FROM
        Member m LEFT JOIN Team t on m.username = t.name

        SQL:
        SELECT m.*,t.* FROM
        Member m LEFT JOIN Team t ON m.username = t.name

        서브 쿼리

        나이가 평균보다 많은 회원
        SELECT m from Member m
        where m.age > (select avg(m2.age) from Member m2)
        -> 일반적으로 성능이 괜찮다.

        한 건이라도 주문한 고객
        SELECT m from Member m
        where (select count(o) from Order o where m = o.member) > 0
        -> 위에 있는 대상을 끌고오면 보통 성능이 잘안나옴!

        서브 쿼리 지원 함수
        [NOT] EXISTS (subquery) : 서브쿼리에 결과가 존재하면 참
        - {ALL | ANY | SOME} (subquery)
        - ALL 모두 만족하면 참
        - ANY, SOME: 같은 의미, 조건을 하나라도 만족하면 참
        - [NOT] IN (subquery): 서브쿼리의 결과 중 하나라도 같은 것이 있으면 참

        예제
        팀A 소속인 회원
        SELECT m from Member m
        where exists (select t from m.team t where t.name = '팀A')

        전체 상품 각각의 재고보다 주문량이 많은 주문들
        select o from Order o
        where o.orderAmount > ALL (select p.stockAmount from Product p)

        어떤 팀이든 팀에 소속된 회원
        select m from Member m
        where m.team = ANY (select t from Team t)

        ****JPA 서브 쿼리 한계****
        - JPA는 WHERE, HAVING 절에서만 서브 쿼리 사용 가능
        - SELECT 절도 가능(하이버네이트에서 지원)

        **- FROM 절의 서브 쿼리는 현재 JPQL에서 불가능**
        -> 1. 조인으로 풀 수 있으면 해결
        -> 2. 쿼리 두번 날리기
        -> 3. from절의 서브쿼리는 대부분 필터가 되기때문에, 갖고와서 애플리케이션에서 조립
        -> 4. 네티이브 쿼리

        JPQL 타입 표현

        - 문자 : 'HELLO', 'She''s'
        - 숫자 : 10L(Long), 10D(Double), 10F(Float)
        - Boolean : TRUE, FALSE
        - ENUM : jpabook.MemberType.Admin (패키지명 포함)
                 -> 타입패러미터 쓰면 생각보다 복잡하진않음
        - 엔티티 타입 : TYPE(m) = Member (상속 관계에서 사용)
        ex)em.craeteQuery("select i from Item i where type(i) = Book", Item.class);

        SQL과 문법이 같은 식
        - EXISTS, IN
        - AND,OR,NOT
        - =,>,>=,<,<=,<>
        - BETWEEN, LIKE, IS NULL


        조건식 - CASE 식
        JPA의 조건식에는 2가지 케이스가 있다.

        1. 기본 CASE 식
        select
            case when m.age <= 10 then '학생요금'
                 when m.age >= 60 then '경로요금'
                 else '일반요금
            end
        from Member m

        2. 단순 CASE 식

        select
            case t.name
                when '팀A' then '인센티브110%'
                when '팀B' then '인센티브120%'
                else '인센티브105%'
            end
        from Team t

        COALESCE : 하나씩 조회해서 null이 아니면 반환
        NULLIF : 두 값이 같으면 null 반환, 다르면 첫번째 값 반환

        ex) 사용자 이름이 없으면 이름없는 회원을 반환
        select coalesce(m.username,'이름 없는 회원') from Member m

        ex) 사용자 이름이 '관리자'면 null을 반환하고 나머지는 본인의 이름을 반환
        select NULLIF(m.username, '관리자') from Member m


        JPQL 기본 함수

        - CONCAT
        - SUBSTRING
        - TRIM (lTrim, rTrim 전부 가능)
        - LOWER, UPPER
        - LENGTH
        - LOCATE
        - ABS, SQRT, MOD
        - SIZE INDEX(JPA 용도)
        (웬만하면 안쓰는게 좋다.)



        사용자 정의 함수 호출
        - 하이버네이트는 사용전 방언에 추가해야 한다.
        -> select function('group_concat', i.name) from Item i
        1. 방언 상속
        2. gradle 커스텀 방언으로 변경!
        3.

     */
}
