package study.data_jpa.chapter08andchapter09.repository;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import study.data_jpa.chapter08andchapter09.entity.Member;
import study.data_jpa.chapter08andchapter09.entity.Team;

public class MemberSpec {
    public static Specification<Member> teamName(final String teamName){
        return (Specification<Member>) (root, query, criteriaBuilder) -> {
            if(StringUtils.isEmpty(teamName)){
                return null;
            }
            Join<Member, Team> t = root.join("team", JoinType.INNER);// 회원과 조인
            return criteriaBuilder.equal(t.get("name"),teamName);
        };
    }

    public static Specification<Member> username(final String username){
        return (Specification<Member>) (root,query,builder)->
            builder.equal(root.get("username"),username);
    }


}
