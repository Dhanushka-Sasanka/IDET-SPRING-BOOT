package com.idet.simple_api.repository;


import com.idet.simple_api.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, String> {

}
