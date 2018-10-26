package com.verizon.emp.dao;

public interface IQueryMapper {

	public static final String INS_EMP_QRY="INSERT INTO empl VALUES(:empid,:ename,:basic,:hra,:dept)";
	public static final String DEL_EMP_QRY="DELETE FROM empl WHERE empid=:empid";
	public static final String UPDATE_EMP_QRY="UPDATE empl SET ename=:ename,basic=:basic,hra=:hra,dept=:dept WHERE empid=:empid";
	public static final String GET_EMP_QRY="SELECT * FROM empl WHERE empid=:empid";
	public static final String GET_ALL__EMP_QRY="SELECT * FROM empl";
	
}
