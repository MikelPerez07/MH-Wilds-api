package com.mpm.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mpm.entities.Item;

@Repository
public interface IItemRepository extends CrudRepository<Item, Long> {

	Item findByName(String itemName);
}
