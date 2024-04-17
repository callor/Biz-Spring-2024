package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;
	
	public UserServiceImpl(
		@Qualifier("passEncoderV1")	PasswordEncoder passwordEncoder, 
		UserDao userDao, RoleDao roleDao) {
		
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}


	/*
	 * 회원가입 절차
	 * 1. 기존에 가입된 회원이 있을까?
	 * 2. 있으면 새로 추가(가입)되는 회원은 일반 사용자
	 * 3. 없으면 새로 추가(가입)되는 회원은 admin 이며 일반 사용자
	 */
	@Override
	@Transactional
	public UserVO createUser(UserVO createUserVO) {

		String username = createUserVO.getUsername();
		String password = createUserVO.getPassword();
		
		List<UserVO> userList = userDao.selectAll();
		
		// 회원 가입시 입력한 password 를 암호화 하기
		String encPassword = passwordEncoder.encode(password);
		createUserVO.setPassword(encPassword);
		
		List<RoleVO> roles = new ArrayList<>();
		// 조건이 true 이면 아직 아무도 회원가입을 하지 않았다
		if(userList == null || userList.size() <= 0) {
			roles.add(RoleVO.builder()
				.r_username(username)
				.r_role("ROLE_ADMIN").build());
			roles.add(RoleVO.builder()
					.r_username(username)
					.r_role("ROLE_USER").build());
		} else {
			roles.add(RoleVO.builder()
					.r_username(username)
					.r_role("ROLE_USER").build());
		}
		userDao.insert(createUserVO);
		roleDao.insertAll(roles);
		return null;
	}
	
	
	/*
	 * @Bean 은 xml 에서 생성했던 bean 을 Annotation 방식으로
	 * 사용하기위한 설정
	 * 
	 * 그런데 여기서는 create_table 을 프로젝트가
	 * 시작될때 자동으로 실행하도록 하기위해 사용
	 * 
	 * 프로젝트가 시작될때 table 이 없으면
	 * 자동으로 생성되는 method 를 실행하기 위함임
	 * 
	 */
	@Autowired
	public void create_table () {
		userDao.create_user_table(null);
		userDao.create_role_table(null);
	}

	
	/*
	 * Controller 에서 Dao 통하여 User 정보를 조회할수 도 있다
	 * 그렇게 하려면 Controller 에서 UserDao 객체를 선언하고 
	 * 		주입을 받아야 한다
	 * 여러곳에서 객체를 주입받는 것도 일종의 메모리 낭비가 될수 있다
	 * 		어차피 Controller 에서는 UserService 를 주입받고 있고
	 * UserService 에서는 UserDao 를 가지고 있으므로
	 * UserService 에 method 하나를 생성하여 사용하는 것이
	 * 		메모리 관리 측면에서 다소 유리하다
	 * UserDao.findById() method 를 호출하고 return 값을
	 * 		Controller 에서 toss 만 하도록 한다
	 */
	@Override
	public UserVO findById(String username) {
		// TODO Auto-generated method stub
		return userDao.findById(username);
	}


}



