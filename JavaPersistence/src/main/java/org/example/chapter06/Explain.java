package org.example.chapter06;

public class Explain {
    /*

    상속관계 매핑

    객체는 상속이 존재
    그러나 관계형 DB는 상속이 없다
    -> 유사한 슈퍼타입, 서브타입 관계 모델링이 존재
    DB 입장에서 3가지 방법이 존재

    JPA에서는 3가지 다 전부 매핑이 가능!
    -> 하나씩 써보고 성능 안좋으면 바꾸기 용이

    1. 조인 전략
    @Inheritance(strategy = InheritanceType.JOINED)
    말 그대로 테이블에 외래키를 둠으로서 조인하는 전략.
    자식 갖고올 때 알아서 잘 Inner 조인으로 갖고온다.

    @DiscriminatorColumn를 사용하게 될 시 DB에 타입 저장!
    구현체마다 다르지만, 부모 엔티티에 DTYPE컬럼이 생김! 이름도 지정할 수 있다.
    **사용 권장!**
    ***싱글 테이블 전략에서는 필수***
    자식의 경우 아래의 함수로 저장될 DTYPE 이름 지정할 수 있다.
    @DiscriminatorValue()

    장점 : 데이터가 정규화가 되어있다. 외래 키 참조 무결성 제약조건 활용 가능, 저장 공간 효율화
    단점 : 조회시 조인을 많이 사용 -> 성능 저하, 조회 쿼리가 복잡함, 데이터 저장 시 INSERT SQL 2번 호출
    총평 : *얘가 정석!!* 조인도 최적화 잘하면 괜찮고 SQL 두번호출은 일도아님

    2. 단일 테이블 전략 (Default 방식)
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    한 테이블로 합쳐버리는 것. D를 상속하는 A,B,C를 합쳐서 하나의 D로 만든다.
    ***DTYPE 필수!***
    @DiscriminatorColumn 없어도 DTYPE 생김!

    장점 : 조인이 필요 없으므로 일반적으로 조회 성능이 빠름, 조회 쿼리가 단순함
    단점 : 자식 엔티티가 매핑한 컬럼은 모두 null 허용,
          단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있고, 상황에 따라서 조회 성능이 오히려 느려질 수 있다.
    총평 : 보통은 조회가 빠름, 1안이랑 트레이드오프 고려, TIP : 정말 단순해! 그럼 이거도 괜찮다.


    3. 구현 클래스마다 테이블 전략
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    위의 전략과 반대로 D를 포함한 A, D를포함한 B, D를포함한 C로 만들어 D를 없앤다.

    **이때 D는 추상클래스로 사용!!**
    @DiscriminatorColumn는 의미가 없기때문에 써도 안생긴다!

    다만 부모타입으로 조회할 때 테이블을 전부 뒤져봐야 하기 때문에 굉장히 복잡한 쿼리가 생긴다!
    -> 굉장히 비추

    장점 : 서브 타입을 명확하게 구분해서 처리할 때 효과적, not null 제약조건 사용 가능
    단점 : 여러 테이블을 함께 조회할 때 성능이 느림(UNION SQL), 자식 테이블을 통합해서 쿼리하기 어려움
    결론 : 쓰지 마라. !!!!



    @MappedSuperclass
    상속관계랑 별 관계는 없다.
    엔티티X, 테이블과 매핑X
    부모 클래스를 상속 받는 자식 클래스에 매핑 정보만 제공
    조회,검색불가(em.find(BaseEntity)불가)
    **추상 클래스로 사용**

    BaseEntity를 만들때 사용!
    -> @MappedSuperclass 넣어줘야 함
    나중에 이벤트라는 기능으로 Modified, last 이런거 자동으로 다 넣게 할 수 있다.


    *참고*
    Entity 클래스는 두가지 경우에만 상속받을 수 있다.
    1. 부모도 Entity 클래스
    2. MappedSuperclass




     */
}
