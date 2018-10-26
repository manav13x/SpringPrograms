package com.verizon.mongoDemo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.mongoDemo.model.Item;

@Repository
public interface ItemMongoRepository  extends MongoRepository<Item, Integer>{

}
