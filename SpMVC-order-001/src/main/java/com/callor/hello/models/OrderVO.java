package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVO {
	private String o_num;	//	varchar(6)
	private String o_date;	//	varchar(10)
	private String o_ccode;	//	varchar(5)
}

