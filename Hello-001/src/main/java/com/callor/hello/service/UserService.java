package com.callor.hello.service;

import com.callor.hello.models.UserDto;

/*
 * interface
 * class 를 만들기 위한 모형(prototype)
 * class 를 만들때 작성 method 에 대한 표준을 정하기
 */
public interface UserService {
	public UserDto getUser();
}
