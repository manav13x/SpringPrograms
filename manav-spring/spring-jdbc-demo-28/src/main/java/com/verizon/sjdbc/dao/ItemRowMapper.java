package com.verizon.sjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.verizon.sjdbc.model.Item;
@Component
public class ItemRowMapper implements	RowMapper<Item>{

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Item item = new Item();
		item.setiCode(rs.getInt(1));
		item.setiName(rs.getString(2));
		item.setiPrice(rs.getDouble(3));
		return item;
	}

}
