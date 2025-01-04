package study.data_jpa.chapter08andchapter09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.data_jpa.chapter08andchapter09.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
