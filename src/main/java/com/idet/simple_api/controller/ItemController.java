package com.idet.simple_api.controller;


import com.idet.simple_api.entity.Item;
import com.idet.simple_api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/item/")
public class ItemController {

    //    @Autowired
    private final ItemService itemService;

    @Autowired
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
//        ItemService itemService = new ItemService();

//        option 1
//        Item serviceItem = itemService.createItem(item);
//        return new ResponseEntity<>(serviceItem, HttpStatus.OK);

//        option 2
        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @DeleteMapping("{itemId}")
    public ResponseEntity<Map<String, Boolean>> removeItem(@PathVariable("itemId") String itemId) {
        return new ResponseEntity<>(itemService.removeItem(itemId), HttpStatus.OK);
    }

    @GetMapping("find-item")
//    @RequestMapping(value = "/find-item" , method = RequestMethod.GET)
    public ResponseEntity<Item> findItemById(@RequestParam("itemId") String itemId) {
        Item itemById = itemService.findItemById(itemId);
        return itemById != null ? new ResponseEntity<>(itemById, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PutMapping("{itemId}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item , @PathVariable("itemId") String itemId ) {
        Item updateItem = itemService.updateItem(item,itemId);
        return updateItem != null ? new ResponseEntity<>(updateItem, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PatchMapping("{itemId}")
    public ResponseEntity<Item> updatePartialItem(@RequestBody Item item , @PathVariable("itemId") String itemId ) {
        Item updateItem = itemService.updatePartialItem(item,itemId);
        return updateItem != null ? new ResponseEntity<>(updateItem, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
