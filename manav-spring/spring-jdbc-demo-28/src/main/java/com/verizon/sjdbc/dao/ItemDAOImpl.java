package com.verizon.sjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.sjdbc.exception.CustomExceptionTranslator;
import com.verizon.sjdbc.model.Item;
@Repository
public class ItemDAOImpl implements ItemDAO {
	
	private JdbcTemplate jtmp;
	@Autowired
	private ItemRowMapper rowMapper;
	
	@Autowired
	public ItemDAOImpl(DataSource ds,CustomExceptionTranslator expt){
		this.jtmp= new JdbcTemplate(ds);
		jtmp.setExceptionTranslator(expt);
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		jtmp.update(IQueryMapper.INS_ITEM_QRY,
				item.getiCode(),
				item.getiName(),
				item.getiPrice()
				);
		
	}

	@Override
	public void removeItem(int iCode) {
		// TODO Auto-generated method stub
		jtmp.update(IQueryMapper.DEL_ITEM_QRY,iCode);
		
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		jtmp.update(IQueryMapper.UPDATE_ITEM_QRY,
				item.getiName(),
				item.getiPrice(),
				item.getiCode()
				);
	}

	@Override
	public Item getItem(int iCode) {
		// TODO Auto-generated method stub
		List<Item> items = jtmp.query(IQueryMapper.GET_ITEM_QRY,new Object[] {iCode}, rowMapper);
		if(items!=null && items.size()>0)
			return items.get(0);
		else
			return null;
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return jtmp.query(IQueryMapper.GET_ALL__ITEMS_QRY, rowMapper);
	}

}
