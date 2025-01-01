package study.data_jpa.chapter06andchapter07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data_jpa.chapter06andchapter07.entity.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
