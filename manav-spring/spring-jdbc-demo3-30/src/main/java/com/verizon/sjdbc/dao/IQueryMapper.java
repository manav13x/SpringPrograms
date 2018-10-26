package com.verizon.sjdbc.dao;

public interface IQueryMapper {

	public static final String INS_ITEM_QRY="INSERT INTO items VALUES(:iCode,:iName,:iPrice)";
	public static final String DEL_ITEM_QRY="DELETE FROM items WHERE icode=:iCode";
	public static final String UPDATE_ITEM_QRY="UPDATE items SET iname=:iName,iprice=:iPrice WHERE icode=:iCode";
	public static final String GET_ITEM_QRY="SELECT * FROM items WHERE icode=:iCode";
	public static final String GET_ALL__ITEMS_QRY="SELECT * FROM items";
	
}
