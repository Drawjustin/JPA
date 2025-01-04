package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PrePersist;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import study.querydsl.entity.Hello;
import study.querydsl.entity.QHello;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
class QuerydslApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Test
	void contextLoads() {
		Hello hello = new Hello();
		em.persist(hello);
		em.flush();
		em.clear();

		JPAQueryFactory query = new JPAQueryFactory(em);
		QHello qHello = QHello.hello;
		Hello result = query
				.selectFrom(qHello)
				.fetchOne();
		assertThat(result.getId()).isEqualTo(hello.getId());



	}

}
