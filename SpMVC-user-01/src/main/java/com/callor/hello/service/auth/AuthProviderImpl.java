package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

// org.mysql.Authen... 사용하면 안됨!!!
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.hello.model.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * Spring Security 에서 인증, 인가 실행(권한부여)
 * 사용자 username, password 를 입력하여 login 을 시도하면
 * 정상적인 사용자 인지 확인을 하고
 * 사용자 정보와 권한정보가 포함된 객체를 생성하여 Token 을 발행한다.
 */
@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// String username = (String)authentication.getPrincipal();
		// String password = (String)authentication.getCredentials();

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		log.debug("USERNAME : {}, PASSWORD : {}",username, password);
		if(username == null || username.isBlank() || !username.equals("callor")) {
			/*
			 * 어떤 method 가 중첩하여 호출이 될때 내부에 깊이 포함된 method 에서
			 * 바깥쪽의 method  에 메시지를 전달하고 싶을때
			 * 강제로(일부러) exception 을 발생하여 전달하는 방법
			 */
			throw new UsernameNotFoundException("USERNAME 없음");
		}
		
		if(password == null || password.isBlank() || !password.equals("12345")) {
			throw new BadCredentialsException("비밀번호 확인필요");
		}
		
		// 로그인한 사용자에게 부여할 권한 리스트 생성
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_GUEST"));
		
		UserVO userVO = UserVO.builder().id(username).username("홍길동")
						.email("callor@callor.com").build();
		// 로그인한 사용자 정보와 권한리스트를 묶어서 Token 발행하기
		UsernamePasswordAuthenticationToken token 
			= new UsernamePasswordAuthenticationToken(userVO,password, grantList);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
