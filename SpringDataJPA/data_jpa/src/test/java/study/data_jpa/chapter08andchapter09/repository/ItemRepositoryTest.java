package study.data_jpa.chapter08andchapter09.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.data_jpa.chapter08andchapter09.entity.Item;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired ItemRepository itemRepository;
    @Test
    public void save(){
        Item item = new Item("A");
        itemRepository.save(item);
    }
}