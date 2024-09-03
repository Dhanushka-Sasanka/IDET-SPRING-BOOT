package com.idet.simple_api.service;


import com.idet.simple_api.entity.Item;
import com.idet.simple_api.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {


    private final ItemRepo itemRepo;

    public Item createItem(Item item) {
        log.info("Item Create method called : {} ", item);
        return itemRepo.save(item);
    }


    public List<Item> getAllItems() {
//        String.format("Danish is %s  %s %d" , "implement a project", "" , 45);
        List<Item> itemList = itemRepo.findAll();
        log.info("All Items : {} ", itemList);
        return itemList;
    }


    public Map<String, Boolean> removeItem(String itemId) {
        HashMap<String, Boolean> map = new HashMap<>();
        Optional<Item> itemById = itemRepo.findById(itemId);
        if (itemById.isPresent()) {
//            delete logic
            itemRepo.deleteById(itemId);
            map.put("delete", Boolean.TRUE);
        } else {
//            data is not found
            map.put("not-found", Boolean.FALSE);
        }
        return map;
    }

    public Item findItemById(String itemId) {

        Optional<Item> itemById = itemRepo.findById(itemId);
        if (itemById.isPresent()) {
            return itemById.get();
        } else {
            return null;
        }

//        return itemById.orElse(null);

    }

    public Item updateItem(Item item, String itemID) {

        Optional<Item> itemById = itemRepo.findById(itemID);
//        if(itemById.isPresent()){
//            Item existsItem = itemById.get();
//            existsItem.setCode(item.getCode());
//            existsItem.setDescription(item.getDescription());
//            existsItem.setUnitPrice(item.getUnitPrice());
//            existsItem.setQytOnHand(item.getQytOnHand());
//            return itemRepo.save(existsItem);
//        }else {
//            return null;
//        }

        itemById.ifPresent(existsItem -> {
            existsItem.setCode(item.getCode());
            existsItem.setDescription(item.getDescription());
            existsItem.setUnitPrice(item.getUnitPrice());
            existsItem.setQytOnHand(item.getQytOnHand());
            itemRepo.save(existsItem);
        });

        return itemById.orElse(null);
    }

    public Item updatePartialItem(Item item, String itemID) {


        Optional<Item> itemById = itemRepo.findById(itemID);
//        if (itemById.isPresent()) {
//            Item existsItem = itemById.get();
//            if (item.getCode() != null) {
//                existsItem.setCode(item.getCode());
//            }
//            if (item.getDescription() != null) {
//                existsItem.setDescription(item.getDescription());
//            }
//            if (item.getUnitPrice() != 0.00) {
//                existsItem.setUnitPrice(item.getUnitPrice());
//            }
//            if (item.getQytOnHand() != 0) {
//                existsItem.setQytOnHand(item.getQytOnHand());
//            }
//            return itemRepo.save(existsItem);
//        } else {
//            return null;
//        }

        itemById.ifPresent(existsItem -> {
            if(item.getCode() != null) existsItem.setCode(item.getCode()); ;
            if(item.getDescription() != null) existsItem.setDescription(item.getDescription()) ;
            if(item.getUnitPrice() != 0.00 ) existsItem.setUnitPrice(item.getUnitPrice());
            if(item.getQytOnHand() != 0)existsItem.setQytOnHand(item.getQytOnHand());
            itemRepo.save(existsItem);
        });

        return itemById.orElse(null);
    }
}
