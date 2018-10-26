package com.verizon.mongoDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.mongoDemo.model.Item;
@Repository
public class ItemDaoImpl  implements ItemDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(item);
	}

	@Override
	public void removeItem(int iCode) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(getItem(iCode));
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		mongoTemplate.save(item);
	}

	@Override
	public Item getItem(int iCode) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(iCode, Item.class);
		
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Item.class);
	}


}
