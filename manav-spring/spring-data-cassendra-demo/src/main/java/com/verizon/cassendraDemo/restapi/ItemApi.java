package com.verizon.cassendraDemo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.cassendraDemo.model.Item;
import com.verizon.cassendraDemo.service.ItemServiceImpl;

@RestController
@RequestMapping("/items")
public class ItemApi {

	@Autowired
	private ItemServiceImpl service;

	@GetMapping
	public ResponseEntity<List<Item>> getAllItems(){
		ResponseEntity<List<Item>> resp = null;
		List<Item> items = service.getItems();
		if(items!=null && items.size()>0)
			resp = new ResponseEntity<List<Item>>(items,HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Item>>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@GetMapping("{icode}")
	public ResponseEntity<Item> getItem(@PathVariable("icode") int icode){
		ResponseEntity<Item> resp = null;
		Item item = service.getItem(icode);
		if(item!=null)
			resp = new ResponseEntity<>(item,HttpStatus.OK);
		else
			resp= new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Item> additem(@RequestBody Item item){
		ResponseEntity<Item> resp = null;
	
		if(item!=null && !service.exists(item.getiCode())){
			service.addItem(item);
			resp = new ResponseEntity<Item>(item,HttpStatus.OK);
		}
		else
		{
			resp = new ResponseEntity<Item>(HttpStatus.CONFLICT);
		
		}
		return resp;
	}
	@PutMapping
	public ResponseEntity<Item> updateitem(@RequestBody Item item){
		ResponseEntity<Item> resp = null;
	
		if(item!=null){
			service.updateItem(item);
			resp = new ResponseEntity<Item>(item,HttpStatus.OK);
		}
		else
		{
			resp = new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		
		}
		return resp;
	}
@DeleteMapping("{icode}")
public ResponseEntity<Void> deleteitem(@PathVariable("icode") int icode){
	ResponseEntity<Void> resp = null;

	if(service.exists(icode)){
		service.removeItem(icode);
		resp = new ResponseEntity<>(HttpStatus.OK);
	}
	else
	{
		resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
	}
	return resp;
}
}