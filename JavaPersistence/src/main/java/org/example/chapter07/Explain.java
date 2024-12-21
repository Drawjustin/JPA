package org.example.chapter07;

public class Explain {
    /*
    프록시와 연관관계 처리

    Member와 Team이 연관관계를 맺고있을때, Member를 조회하면 Team도 같이 조회된다.
    이때 Team의 정보도 필요한 경우라면 상관없지만, Member만 출력하는 경우를 생각하면 자원 낭비다.

    ->  지연 로딩과 프록시를 이용해 해결!

    em.find() vs em.getReference()

    em.find() : 실제 엔티티 조회
    em.getReference() : 프록시 객체 조회 (바로 DB에 쿼리가 안나감, 지연 로딩)
                        실제 엔티티를 상속받아서 만드며 실제 클래스랑 겉모양이 똗같다.
                        하이버네이트가 내부적으로 프록시 라이브로이드를 써서 만든다.

    프록시 객체의 초기화
    첫번째 호출 : getName() -> 값이 없으니, 영속성 컨텍스트에 요청 -> db에서 조회해서 엔티티 생성 -> 프록시 객체와 엔티티 객체 연결
    두번째 호출 : getName() -> 값이 있으니 반환

    프록시 객체의 특징
    1. 처음 사용할 때 한번만 초기화
    2. 프록시 객체가 실제 엔티티로 바뀌는 것이 아님, 프록시 객체가 엔티티를 가리키는 것(주소참조)
    3. 프록시 객체는 원본 엔티티를 상속받음, 따라서 타입 체크시 주의해야함(== 비교 XX, instance of 사용)
       어떤건 find, 어떤건 getReference 일때 문제 발생
    4. 영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference를 호출해도 실제 엔티티를 반환한다.
       똗같은 Key를 갖는 객체를 find, getReference를 호출하면 영속성 컨텍스트에있는 실제 객체가 저장됨
       Why ? -> 성능 최적화, == 비교할때 true로 만들어 주기 위해서 실제 엔티티로 반환
       getReference 후 find 하면 둘다 프록시 객체 반환

  **5. 영속성 컨텍스트의 도움을 받을 수 없는 준영속 상태일 때, 프록시를 초기화 하면 문제 발생**
       em.detach(), em.close(), LazyInitializationExcepion 발생!

    프록시 유틸리티
    1. 프록시 인스턴스의 초기화 여부 확인
    -> emf.getPersistenceUnitUtil().isLoaded(Object entity)
    2. 프록시 클래스 확인 방법
    -> entity.getClass().getName() 출력
    3. 프록시 강제 초기화
    -> org.hibernate.Hibernate.initialize(entity)

    참고 : JPA 표준은 강제 초기화 없음

  **Tip : getReference 많이 안씀!!**


  ***즉시 로딩과 지연 로딩***

  지연로딩은 프록시 객체를 반환!
  @ManyToOne(fetch = FetchType.LAZY)
  -> 프록시 객체를 사용할 때 프록시 객체가 초기화 됨 (이때 DB에 쿼리가 나감!)
  단, 쿼리가 따로 나가기때문에 성능상 약간의 손해를 봄
  -> 객체를 자주 사용하는 경우 즉시 로딩 사용할 수 도 있음(그래도 비추)

  즉시로딩은 한번에 다 갖고오는 것
  @ManyToOne(fetch = FetchType.EAGER)
  -> 조인을 활용해서 한번에 갖고온다

  김영한님 피셜)
  **결론 : 가급적 지연 로딩만 사용(특히 실무에서)**
  -> Why ???
  1. 즉시 로딩을 적용하면 예상하지 못한 SQL 발생 (테이블이 복잡할 수록 성능저하)
  2. 즉시 로딩은 JPQL에서 N+1 문제를 일으킨다.
  -> 멤버 10명이 들어있으면, 최초쿼리 1번, 팀조회쿼리 10번해서 1+N문제라고 함
  -> **Lazy는 3가지 대안이 있다.**
     1. 패치 조인(JPQL)
     2. Entity Graph(어노테이션)
     3. 배치 사이즈 (1+N -> 1+1으로 해결됨)

  **주의**
  @ManyToOne, @OneToOne는 기본이 즉시 로딩
  -> LAZY로 설정
  @OneToMany, @ManyToMany는 기본이 지연 로딩


  영속성 전이 : CASCADE

  특정 엔티티를 영속 상태로 만들 때 연관된 엔티티도 함께 영속 상태로 만들고 싶을 때
  ex) 부모 엔티티를 저장할 때 자식 엔티티도 함께 저장.
  @OneToMany(mappedBy="parent", cascade=CascadeType.ALL)

  주의
  영속성 전이는 연관관계를 매핑하는 것과 아무 관련이 없음, 편리함 그 뿐

  종류
  ALL(모두다),PERSIST(저장할때만),REMOVE(삭제할때만)

  하나의 부모가 자식들을 관리할때는 의미가있다.
  ex) 게시판과 첨부파일
  그러나 첨부파일을 여러 군데에서 관리할때는 사용하면 안된다.
  즉 다른곳에서 자식을 알고있다(참조하고있다) 그러면 쓰면 안된다.

  두 가지를 만족할 때 사용할 수 있다.
  1. 부모랑 자식의 라이프 사이클이 똗같으며
  2. 단일 소유자일 때


  고아객체

  고아 객체 제거 : 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제
  @OneToMany(mappedBy="parent", cascade=CascadeType.ALL, orphanRemoval = true)
  parent1.getList().remove(0);
  0번 고아객체 삭제 delete 쿼리가 나감!

  주의
  참조가 제거된 엔티니는 다른 곳에서 참조하지 않는 고아 객체로 보고 삭제하는 기능

  두 가지를 만족할 때 사용할 수 있다.
  1. 참조하는 곳이 하나일때 사용
  2. 특정 엔티티가 개인 소유할 때 사용

  @OneToOne, @OneToMany만 가능

  부모가 사라지면 고아가 되기때문에, 부모를 삭제하는 경우에는 @CascadeType.Remove처럼 동작한다.

  CascadeType.ALL + orphanRemovel=true
  [원래 스스로 생명주기를 관리하는 엔티티는 em.persist()로 영속화, em.remove()로 제거]
  *두 옵션을 모두 활성화 하면 부모 엔티티를 통해서 자식의 생명주기를 관리할 수 있음*
  *도메인 주도 설계(DDD)의 Aggregate Root개념을 구현할때 유용*
















     */
}
