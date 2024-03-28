package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 주문과 고객정보를 join 하여 리스트를 확인하기 위한 Data class
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCustomVO {
	
	private String o_num;	//	varchar(6)
	private String o_date;	//	varchar(10)
	private String o_ccode;	//	varchar(5)
	
	private String c_code;	// varchar(5)
	private String c_name;	// varchar(25)
	private String c_tel;	//	varchar(15)
}
