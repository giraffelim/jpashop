package com.girrafelim.study.repository;

import com.girrafelim.study.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        // 아이디 값이 있으면 이미 등록이 되어 있는 것
        if(item.getId() == null){
            em.persist(item); // 신규 등록
        } else {
            em.merge(item); // merge는 update는 비슷함
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
