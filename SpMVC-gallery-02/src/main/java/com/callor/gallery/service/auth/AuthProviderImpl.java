package com.callor.gallery.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		if(username == null || username.isBlank() 
				|| !username.equalsIgnoreCase("callor")) {
			throw new UsernameNotFoundException("사용자이름 확인");
		}
		
		if(password == null || password.isBlank() || !password.equals("1234")) {
			throw new BadCredentialsException("비밀번호 확인");
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("USER"));
		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		
		UsernamePasswordAuthenticationToken token
		= new UsernamePasswordAuthenticationToken(username, password,grantList);
		return token;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
