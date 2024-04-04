package com.callor.iolist.service.impl;

import org.springframework.stereotype.Service;

import com.callor.iolist.models.UserVO;
import com.callor.iolist.service.UserService;
import com.callor.iolist.utils.NamesValue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NamesValue.QUALIFIER.USER_SERVICE_V1)
public class UserServiceImplV1 implements UserService{

	/*
	 * username 과 password 를 매개변수로 전달받아
	 * 사용자 정보 확인을 하고, 
	 * 		맞으면 사용자 정보가 담긴 UserVO 객체를 return
	 */
	@Override
	public UserVO login(String username, String password) {
		log.debug("USERNAME {}, PASSWORD {}",username, password);
		if(username.equalsIgnoreCase("callor") && password.equals("12345")) {
			UserVO userVO = UserVO.builder()
							.username(username)
							.password(password)
							.tel("010-1111-1111")
							.name("이몽룡")
							.email("callor@callor.com")
							.build();
			return userVO;
		}
		return null;
	}

}
