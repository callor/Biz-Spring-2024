package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authorProviderImpl")
public class AuthorProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String u_name = authentication.getName();
		String u_pasword = authentication.getCredentials().toString();
		
		Map<String, String> user = new HashMap<>();
		user.put("username", u_name);
		user.put("email", "callor@callor.com");
		throw new UsernameNotFoundException("USERNAME 없음");

//		List<GrantedAuthority> grantList = new ArrayList<>();
//		grantList.add(new SimpleGrantedAuthority("ADMIN"));
//		grantList.add(new SimpleGrantedAuthority("USER"));
//		
//		UsernamePasswordAuthenticationToken token
//		= new UsernamePasswordAuthenticationToken(user,u_pasword, grantList);
//		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
