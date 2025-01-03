package study.data_jpa.chapter08;

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



     */
}
