package org.example.chapter05;

public class Explain {
    /*
        연관관계 매핑시 고려사항 3가지
        1. 다중성 : @ManyToOne, @OneToMany, @OneToOne, @ManyToMany(금지)
        2. 단방향,양방향
        3. 연관관계의 주인

        테이블 : 외래 키 하나로 양쪽 조인 가능
        객체 : 참조용 필드가 있는 쪽으로만 참조 가능
        -> 한쪽만 존재(단방향) 양쪽에 존재(양방향)

        참조가 두개일 경우 테이블을 관리할 참조를 정해줘야 함!(외래키를 받은 테이블 쪽으로 관리)

        ※연관관계에서 앞의글자가 주인임※

        다대일[N:1]
        가장 보편적으로 많이 사용하는 경우. 김영한 선생님께서 강추함.(성능,이치에맞음)

        일대다[1:N]
        @JoinColumn 필수 !!
        -> 안쓰게되면 조인 테이블 방식을 사용함(중간에 테이블 하나 추가함)
        비추하는 이유
        1. 테이블과 연관관계가 반대로 되어있기 때문에, 업데이트 쿼리가 한번 더 나감.
        2. A테이블을 건드렸는데, B테이블 업데이트문이 나가면, 굉장히 헷갈림
        -> 쓸일이 있으면 다대일 양방향으로 설정하는 것을 추천
        억지로 쓸수는 있다
        @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)

        일대일[1:1]
        주 테이블이나 대상 테이블 중에 외래 키 선택 가능
        외래 키에 데이터 베이스 유니크 제약조건 추가
        ex) Member <-> Locker
        대상 테이블에 외래 키 단방향 XX JPA 지원 X
        -> 저도 정확한 이유는 잘 모르겠지만, 아마 일대일은 실용성이 떨어져서 넣지 않았을 것 같아요.
        양방향 관계는 지원
        -> 쉽게 설명하면 내 엔티티의 외래 키를 내가 직접 관리

        고려사항
        주 테이블 외래키
            객체지향 개발자 선호
            주 테이블만 조회해도 대상 테이블에 데이터가 있는지 확인 가능
        단점:값이 없으면 외래키에 NULL 허용
        대상 테이블에 외래 키
            DB 개발자 선호
            주 테이블과 대상 테이블을 일대일에서 일대다로 변경할 때 테이블 구조 유지
        단점:프록시 기능의 한계로 지연 로딩으로 설정해도 항상 즉시 로딩됨

        다대다[N:N]
        관계형 데이터베이스는 정규화된 테이블2개로 다대다 관계를 표현할 수 없음
        -> 일대(다)대일로 풀어내야 함

        한계 : 편리해 보이지만 실무에서 사용 XXX
        Why? -> 연결 테이블에 주문시간, 수량같은 데이터가 들어올 수 있음
                이때 추가 정보 넣는게 불가능
        해결 : 중간 테이블 엔티티로 승격 !!

        이때, 2가지 경우의수가 있는데
        1. FK 두개를 묶어서 PK로 사용(합성키, 전통적인 방식)
        2. PK 별도로 사용
        -> 김영한 피셜:) 실무용으로 2번 추천!
        Why? -> PK가 어디에 종속되면 갈아치우기가 어렵더라

     */
}
