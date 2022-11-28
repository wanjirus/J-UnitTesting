package com.UnitTestDemo.unitTest.controller;

import com.UnitTestDemo.unitTest.business.ItemBusinessService;
import com.UnitTestDemo.unitTest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;
    @GetMapping("/dummy-item")
    public Item getItem(){
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retrieveHardcodedItem();

    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        return businessService.retrieveAllItems();
    }
}
