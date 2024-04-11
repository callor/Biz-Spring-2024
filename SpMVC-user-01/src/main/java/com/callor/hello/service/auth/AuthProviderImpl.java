package com.callor.hello.service.auth;

// org.mysql.Authen... 사용하면 안됨!!!
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		
		log.debug("USERNAME : {}, PASSWORD : {}",username, password);
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
