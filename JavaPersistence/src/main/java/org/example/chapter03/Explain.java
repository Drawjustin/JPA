package org.example.chapter03;

public class Explain {
    /*

    // 테이블 이름을 지정할 수 있음
    @Table

    // value 에따라 DDL을 생성 시기를 정할 수 있음
    <property name="hibernate.hbm2ddl.auto" value="create" />

    create - 기존 테이블 삭제 후 @Entity 붙은 클래스 테이블 생성 (운영DB에는 사용하면 안됨)
    create-drop - 위와 동일하나 프로그램 종료시 테이블 삭제 (운영DB에는 사용하면 안됨)
    update - 변경분만 반영 remove한 컬럼은 반영 x (운영DB에는 사용하면 안됨)
    validate - 엔티티와 테이블이 정상 매핑되었는지 확인
    none - 사용하지 않음

    개발 초기 - create or update
    테스트 서버 - update or validate
    스테이징과 운영 서버 - validate or none

    왠만하면 validate or none만 사용 !!

    // value값으로 방언을 바꿔줄 수있음
    <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
    mysql,oracle 등등..


    // 컬럼을 직접 매핑하거나 속성을 줄 수 있다.
    @Column(unique = true, length = 10)
    이런 기능은 DDL 생성할 때에만 영향을 준다.


    // Entity 어노테이션 정리
    기본키 매핑
    @Id : 기본 키 등록 (직접 할당)
    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    GeneratedValue : 자동 생성 (데이터베이스에 위임)
    strategy -> 키 생성 전략
    IDENTIFY : auto_increment
    단점 : 영속성 컨텍스트에서 객체를 관리하려면 PK값을 알고있어야 하는데,
          IDENTIFY의 경우 DB에서 받아오기전까지 알 수 없기때문에,
          persist 하자마자 실제로 Insert 쿼리를 날려버림.
        -> 모아서 Insert하는게 불가능함
     경험: 한 트랜잭션 내에서 인서트 쿼리가 여러번 네트워크를 타도 비약적인 성능차이는 없더라.



    SEQUENCE : 데이터베이스 시퀀스 사용
        -> 테이블 어노테이션 @SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq",
                                            initialValue = 1, allocationSize = 1)
    동작 : 영속성 컨텍스트에서 객체를 관리하려면 PK값을 알고있어야 하는데,
         SEQUENCE의 경우 DB에서 받아오기 전까지 알 수 없기 때문에,
         persist하자마자 SEQ를 얻어옴
        -> 네트워크를 매번 왔다갔다 해야하지만, 모아서(Buffering) 보낼 수 있음
     해결 : allocationSize = 50
            한 번의 네트워크 연결에서 50개를 미리 사용권한을 받아온다.
            메모리에서 이 개수만큼 사용하고 다쓰면 다시 네트워크 연결 !

    TABLE : 잘 안씀..?
    키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략
    장점: 모든 DB에 적용 가능
    단점: 성능

    여기서 잠깐! TIP : LONG, Integer 지금은 성능차이 거의없다. 그냥 LONG 쓰자!


    권장하는 식별자 전략

    기본 키 제약 조건 : null 아님, 유일, **변하면 안된다**
    권장 : Long형 + 대체키(UUID) + 키 생성전략 사용(auto_increment,SEQUENCE)



    @Column : 필드 매핑
    (name = "name", updatable = false, nullable = false, unique = true, length = 10, columnDefinition = "varchar(100) default deafult 'EMPTY'")
    updatable -> JPA에서 절대 업데이트 하지 않음, nullable -> not null, unique -> unique
    length -> 길이, columnDefinition -> DB의 종속적인 옵션 넣기

    @Enumerated : EnumType 사용할 때 사용
    (EnumType.STRING)
    Ordinal -> Default 타입, Enum 순서를 데이터베이스에 저장 절대 사용 X
    새로운 Enum이 추가되었을때, 기존의 1번 Enum이 누구인지 알 도리가 없기 때문.
    String ->  Enum 이름을 데이터베이스에 저장

    @Temporal(TemporalType.TIMESTAMP) : 날짜 데이터 사용할 때 사용
    LocalDate, LocalDateTime 에는 생략 가능! (최신)
    Date 타입일때 사용
    Date -> 날짜
    Time -> 시간
    TIMESTAMP -> 날짜+시간

    @Lob : 큰 문자열 사용할 때 사용
    CLOB -> 매핑하는 필드타입이 문자
    BLOB -> 매핑하는 필드타입이 문자 이외

    @Transient ; 메모리에서만 사용
    저장X매핑X조회X

     */
}
