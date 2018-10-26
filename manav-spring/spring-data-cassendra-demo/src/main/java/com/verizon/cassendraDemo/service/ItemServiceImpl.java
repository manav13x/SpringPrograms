package com.verizon.cassendraDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.cassendraDemo.dao.CassendraRepo;
import com.verizon.cassendraDemo.model.Item;


@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	private CassendraRepo itemDAO;
	
	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		itemDAO.insert(item);
	}

	@Override
	public void removeItem(int iCode) {
		// TODO Auto-generated method stub
		itemDAO.deleteById(iCode);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		itemDAO.save(item);
	}

	@Override
	public Item getItem(int iCode) {
		// TODO Auto-generated method stub
		Optional<Item> opt = itemDAO.findById(iCode);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return itemDAO.findAll();
	}

	@Override
	public boolean exists(int iCode) {
		// TODO Auto-generated method stub
		return itemDAO.existsById(iCode);
	}

}
