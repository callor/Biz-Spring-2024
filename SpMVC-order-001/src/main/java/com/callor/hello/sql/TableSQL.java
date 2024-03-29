package com.callor.hello.sql;

public class TableSQL {
	
	public final static String ORDER_CUSTOM = " SELECT * "
			+ " FROM tbl_orders O "
			+ "	JOIN tbl_customer C "
			+ "		ON O.o_ccode = C.c_code "
			+ " ORDER BY O.o_num  ";
}
