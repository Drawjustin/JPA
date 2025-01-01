package study.data_jpa.chapter06andchapter07.repository;

import study.data_jpa.chapter06andchapter07.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
