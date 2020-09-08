package com.girrafelim.study.service;

import com.girrafelim.study.domain.item.Book;
import com.girrafelim.study.domain.item.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    ItemService itemService;

    @Test
    public void 아이템_저장_테스트() throws Exception{

        //given
        Item item = new Book();
        item.setName("1A");

        //when
        itemService.save(item);

        //then
        assertEquals(item, itemService.findOne(item.getId()));

    }
}