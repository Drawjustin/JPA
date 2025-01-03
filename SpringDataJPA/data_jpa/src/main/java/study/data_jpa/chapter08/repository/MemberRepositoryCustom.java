package study.data_jpa.chapter08.repository;


import study.data_jpa.chapter08.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
