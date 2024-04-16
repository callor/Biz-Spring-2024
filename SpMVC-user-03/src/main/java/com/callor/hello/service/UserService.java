package com.callor.hello.service;

import com.callor.hello.models.UserVO;

public interface UserService {
	
	// 회원가입을 할때 사용할 method

	// Java DOCS : ** 로 시작되는 주석 
	/**
	 * 
	 * 회원가입 method
	 * UserVO 에 담긴 사용자 정보를 전달받아 
	 * 회원 테이블에 데이터 추가
	 * 
	 * @param createUserVO
	 * @return UserVO
	 * @author callor
	 * @since 2024-04-15
	 * 
	 */
	public UserVO createUser(UserVO createUserVO);

}
