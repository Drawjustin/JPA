package study.data_jpa.chapter08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data_jpa.chapter08.entity.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
