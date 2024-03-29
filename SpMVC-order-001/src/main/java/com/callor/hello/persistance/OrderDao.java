package com.callor.hello.persistance;

import java.util.List;

import com.callor.hello.models.OrderVO;

/*
 * DBMS 연동 프로젝트에서 필수적으로 
 * 구현이 필요한 5가지 method 구조
 */
public interface OrderDao {
	
	// table 의 모든 데이터들을 SELECT 하기
	// 이 함수의 return type 이 무엇일까
	public List<OrderVO> selectAll();
	public void findByPK(String pk);
	
	public int insert(OrderVO orderVO);
	public int update(OrderVO orderVO);
	public int delete(String pk);

}





