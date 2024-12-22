package org.example.chapter08;

public class Explain {
     /*
        값 타입

        JPA의 데이터 타입 분류

        크게 2가지 종류로 나눌 수 있다.

        엔티티 타입
        - Entity로 정의하는 객체
        - 데이터가 변해도 식별자로 지속해서 추적 가능
        ex) 회원 엔티티의 키나 나이 값을 변경해도 식별자로 인식 가능

        값 타입
        - int, Integer, String처럼 단순히 값으로 사용하는 자바 기본 타입이나 객체
        - 식별자가 없고 값만 있으므로 변경시 추적 불가
        ex) 숫자 100을 200으로 변경하면 완전히 다른 값으로 대체




        값 타입은 3가지로 나눌 수 있다.

        1. 기본 값타입
        - 자바 기본 타입(int, double)
        - 래퍼 클래스(Integer,Long)
        - String

        생명주기를 엔티티에 의존
        ex) 회원을 삭제하면 이름,나이 필드도 함께 삭제
        값 타입은 공유하면 X
        ex) 회원 이름 변경시 다른 회원의 이름도 함께 변경되면 안됨


        2. 임베디드 타입
        - embedded type, 복합 값타입
        ex) (x,y) 좌표

        새로운 값 타입을 직접 정의할 수 있음
        JPA는 임베디드 타입이라 함
        주로 기본 값 타입을 모아서 만들어서 복합 값 타입이라고도 함
        int, String과 같은 값 타입

        임베디드 타입 사용법
        @Embeddable : 값 타입을 정의하는 곳에 표시
        @Embedded : 값 타입을 사용하는 곳에 표시
        *기본 생성자 필수*

        임베디드 타입 장점
        재사용성 높음
        높은 응집도
        Period.isWork()처럼 해당 값 타입만 사용하는 의미 있는 메소드를 만들 수 있음
        임베디드 타입을 포함한 모든 값 타입은, 값 타입을 소유한 엔티티에 생명주기를 의존함

        뭐가 좋은 것인가?
        **임베디드 타입을 사용하기 전과 후에 매핑하는 테이블은 같다.**
        -> 객체와 테이블을 아주 세밀하게 매핑하는 것이 가능하다.
        잘 설계한 ORM 어플리케이션은 매핑한 테이블의 수보다 클래스의 수가 더 많음
        -> 용어 공통, 코드 공통, 도메인의 언어 공통 등 장점이 많다!

        한 엔티티 안에서 같은 값 타입을 사용하면?
        -> @AttributeOverrides, @AttributeOverride를 사용해서 컬럼명 속성 재정의

        @AttributeOverrides({
            @AttributeOverride(name="city",
                            column=@Column(name = "WORK_CITY"))
        })

        보통 어노테이션 들어가면 주석으로 어떻게 사용해야하는지 설명이 잘되어있음!

        임베디드 타입이 null이면 매핑한 값도 전부 null~





        -- 쉬어가는 타임 --
        값 타입과 불변객체

        값 타입 - 복잡한 객체 세상을 조금이라도 단순화 하려고 만든 개념

        객체 타입의 한계
        Address a = new Address("old");
        Address b = a;
        b.setCity("New");
        -> 공유 참조.. 막을 방법이 없다! 언제든지 실수할 수 있는 여지가 있다.

        **값 타입 공유 참조**
        임베디드 타입 같은 값 타입을 여러 엔티티에서 공유하면 위험함
        부작용(side effect) 발생
        -> 의도적으로 공유하게만들었다면 엔티티로 만들어 공유하자!
        -> 의도적이지 않았다면, 불변객체를 사용하자!
        생성자로만 값을 생성하고, Setter를 사용하지 말것
        또는 Setter를 private 설정할것

        아 그래도 나 값 변경하고 싶은데!!
        -> 새로 만드셔야 합니다..^o^

        결론 : 값 타입은 무조건 불변으로!!

        값 타입의 비교

        값 타입 : 인스턴스가 달라고 그안에 값이 같으면 같은 것으로 봐야함
        당연히 == 비교는 주소 비교이기때문에 불변객체를 사용해도 false가 나온다.
        -> equals() 오버라이딩 사용!
        단, equals를 구현하면 hashcode도 거기에 맞춰서 구현해줘야 함
        Why ? -> 해시를 사용하는 자바 컬렉션에서 정합성 및 효율적으로 사용하기 위해서

        김영한님피셜)
        Tip : 실무에서 비교할 일이 많진 않더라

        3. 컬렉션 값 타입
        - 자바 컬렉션에 기본 값 타입, 임베디드 타입을 넣을 수 있는 것

        엔티티를 컬렉션으로 쓴적있듯이,
        값 타입을 컬렉션으로 사용하는것이다!

        원래 기존의 관계형 DB는 내부적으로 컬렉션을 담을 수 있는 구조가 없었다
        -> 최근에는 몇몇 DB가 되기도 함 (JSON 이런거 지원하면서)

        식별자 id같은 개념을 넣어서 PK를 구성하게되면 값 타입이 아니라 엔티티가 되어버림
        -> 합성 키가 많더라(객체를 구성하는 값이 전부 PK)
        -> NULL 입력안되고, 중복저장도 안됨..

        @ElementCollection
        @CollectionTable(name = "FAVORITE_FOOD")
        private Set<String> favoriteFoods = new HashSet<>();

        String 애는 예외적으로 매핑하게 허용해줌!
        @ElementCollection
        @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID"))
        @Column(name = "FOOD_NAME")
        private Set<String> favoriteFoods = new HashSet<>();


        컬렉션 값 타입 사이클도 스스로의 라이프 사이클이 없다!
        -> em.persist(member) 할 때 값 타입 컬렉션도 다 넣어짐!
        -> member값 바꾸면 알아서 업데이트됨!

        **** 컬렉션 값 타입은 전부 지연로딩!!!! ****
        Member08col findmember = em.find(Member08col.class, member.getId());


        **컬렉션 값 타입 수정 틀린 예제!!!**
        findmember.getPeriodHistory().setPeriod() XXXX
        -> 새로 만들자!

        Period06col a = findmember.getPeriod();
        findmember.setPeriod06col(new Period06col(a.getStartDate(),LocalDateTime.now()));
        이런식으로!!

        단, 엔티티처럼 해당 멤버의 모든 Period가 바뀌는것이 아님을 주의
        --> 값 추적이 안됨..


        Set<String>에서 값을 바꾸고 싶을 때?
        //치킨 -> 한식
        findmember.getFavoriteFoods().remove("치킨");
        findmember.getFavoriteFoods().add("한식");


        정리 : 값 타입 컬렉션이란, 멤버에 의존관계를 다 맡기는 것!


        Tip : 대부분 컬렉션들은 대상을 찾을때 equals를 사용한다.
        Tip : JPA가 플러시할때에는 알아서 적절한 순서대로 명령의 순서를 고른다!


        값 타입 컬렉션의 제약사항

        값 타입은 엔티티와 다르게 식별자 개념이 없다.
        값은 변경하면 추적이 어렵다.
        **값 타입 컬렉션에 변경 사항이 발생하면, 주인 엔티티와 연관된 모든 데이터를 삭제하고, 값 타입 컬렉션에 있는 현재 값을 모두 다시 저장한다**
        --> 비효율적인데..? @OrderColumn 쓰면 해결되긴한다
        -> 이것도 엄청 위험함
        -->>> 김영한님피셜) 이렇게 위험하고 복잡하게 쓸빠에는 쓰면 안된다!!
        + 단점) 값 타입 컬렉션을 매핑하는 테이블은 모든 컬럼을 묶어서 기본 키를 구성해야함 : null 입력X, 중복 저장X

        --> 실무에서는 값 타입 컬렉션 대신에 일대다 관계를 고려!
        --> 값 타입 승급-> 엔티티!
        ex) 주소 이력, 주소가 사라져도 이력은 남겨야하잖아요? 이런거 전부 엔티티.

        ****식별자가 필요하고 지속해서 값을 추적, 변경해야 한다면 그것은 값 타입이 아닌 엔티티****

        다음과 같이 사용!
        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "MEMBER_ID")
        private List<AddressEntity> addressHistory = new ArrayList<>();


        **Tip : equals와 hashcode 만들떄, use getter during 옵션 사용하는게 좋음**
        ->  직접 접근하면 프록시에서 제대로 동작하지 않을 수 있음

        embeddable 값 타입은 유용하게 사용할만하다

     */
}
