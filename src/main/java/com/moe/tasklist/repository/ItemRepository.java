package com.moe.tasklist.repository;


import com.moe.tasklist.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
