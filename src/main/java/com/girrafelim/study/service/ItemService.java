package com.girrafelim.study.service;

import com.girrafelim.study.domain.item.Book;
import com.girrafelim.study.domain.item.Item;
import com.girrafelim.study.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void save(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, Book param) {
        // 트랜잭션 안에서 조회를 해야 영속 상태로 조회가 된다.
        Item findItem = itemRepository.findOne(itemId); // 실제 영속성 컨텍스트에 있는 엔티티를 가져온다 [ 영속 상태 ].
        findItem.setPrice(param.getPrice());
        findItem.setName(param.getName());
        findItem.setStockQuantity(param.getStockQuantity());
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

}
