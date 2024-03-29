package com.callor.hello.persistance;

import java.util.List;

import com.callor.hello.models.OrderCustomVO;

public interface OrderCustomDao {

//	@Select(TableSQL.ORDER_CUSTOM)
	public List<OrderCustomVO> selectAll();
	
}
