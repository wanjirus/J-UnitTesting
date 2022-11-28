package com.UnitTestDemo.unitTest.data;

import com.UnitTestDemo.unitTest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
