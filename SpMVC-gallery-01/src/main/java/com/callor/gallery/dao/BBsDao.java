package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.BBsVO;

/*
 * Generic interface 상속하여 Dao interface 만들기
 * GenericDao 에 선언된 5가지 CRUD method 는 그대로 상속을 받는다
 * 		이때 Return type 과 PK 매개변수의 type 을 필요한 요소로 대체한다
 * 		대체할때 Generic Type(<>)에 명시해 준다
 * 그외 필요한 method 가 있으면 별도로 선언하여 사용 할 수 있다
 * 
 * 결국 BBsDao 에는 총 8가지의 method 가 선언되는 것과 같다
 * 
 */
public interface BBsDao extends GenericDao<BBsVO, String>{

	
	public List<BBsVO> findByDate(String sdate, String edate);
	public List<BBsVO> findBySubject(String subject);
	public List<BBsVO> findByContent(String content);
	
	
//	public List<BBsVO> selectAll();
//	public BBsVO findById(String pk);
//	
//	public int insert(BBsVO vo);
//	public int update(BBsVO vo);
//	public int delete(String pk);

}
