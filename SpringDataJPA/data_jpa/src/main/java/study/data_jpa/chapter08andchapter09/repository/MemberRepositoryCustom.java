package study.data_jpa.chapter08andchapter09.repository;


import study.data_jpa.chapter08andchapter09.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
