package com.callor.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * Spring Security 5.3.x 버전까지 유효한 설정 코드
 * Spring Security 5.4.x 이후 버전에서는 새로운 설정코드를 사용해야 한다
 * Spring Framework 와 Spring Security 한 프로젝트에서 사용하지만
 * 		서로 연결되지 않는 Framework
 */
@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter{

	/*
	 * webapp/static 폴더 : Static 파일들(js, CSS, Image 등등)을 저장하는 폴더는
	 * controller, Dispatcher 등을 통하지 않고 client 로 바로 전달하는 파일이
	 * 보관된 폴더
	 * security 에서도 이 폴더의 파일은 관여하지 않도록 선언할수 있는데
	 * 그때 config(WebSecurity web) method 에서 선언한다
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}

	/*
	 * xml 방식에서 <sec:http> .. </sec:http> 를 설정했던 부분을
	 * 설정하는 method
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // spring Security 설정 시작
		.antMatchers("/hello").hasAnyRole("USER","ADMIN") // 로그인이 되고, 권한이 USER, ADMIN
		.antMatchers("/user/mypage").authenticated() // 로그인이 되어 있는 경우
		// .antMatchers("/**").permitAll() // 그외 모든
		.anyRequest().permitAll() // 그외 모든 요청은 그냥 통과
		.and().formLogin();
	}
}
