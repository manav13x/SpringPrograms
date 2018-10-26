package com.verizon.emp.dao;

public interface IQueryMapper {

	public static final String INS_EMP_QRY="INSERT INTO empl VALUES(?,?,?,?,?)";
	public static final String DEL_EMP_QRY="DELETE FROM empl WHERE empid=?";
	public static final String UPDATE_EMP_QRY="UPDATE empl SET ename=?,basic=?,hra=?,dept=? WHERE empid=?";
	public static final String GET_EMP_QRY="SELECT * FROM empl WHERE empid=?";
	public static final String GET_ALL__EMP_QRY="SELECT * FROM empl";
	
}
