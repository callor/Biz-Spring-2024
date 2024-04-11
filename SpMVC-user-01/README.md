# Spring Security Project
- 프로젝트에서 사용자의 로그인이 필요한 경우 `HttpSession` 을 사용하여 각 요청에 대하여 로그인이 되어 있는지 확인하고, 로그인이 되어 있지 않으면 로그인 화면으로 `redirect`하는 코드를 작성해야 한다.
- 만약 로그인이 필요한 `RequestMapping(method)`가 많을 경우 관리하기가 매우 불편한 상황이 된다.
- 이때 `Spring Security` 도구를 사용하면, `web.xml`에 `Filter`를 설정하고, security-context.xml 을 설정하므로써 각 요청 패턴에 따라 자동으로 로그인, 세션설정등을 할수 있다.

## Spring Security 에서 보안과 관련한 용어
- 인증 : 프로젝트에 아이디와 패스워드를 사용하여 로그인을 수행하고, 정상적인 사용자인지 확인하는 절차
- 인가 : 정상적으로 로그인한(인증한) 사용하에게 어떤 권한(역할, ROLE)을 부여하는 것

## Spring Security 설정
- `기본 dependency`
- `Spring Framework 는 5.x.RELEASE`를 사용하는 관계로 , `spring Security 는 5.3.13.RELEASE`를 사용한다. `5.3.13.RELEASE` 보다 높은 버전은 `Spring Framework` 와 버전충돌이 발생할수 있다.
- `RELEASE` 가 부착된 버전중에 가장 최신버전을 사용하라.
```xml
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-web</artifactId>
	<version>5.3.13.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-config</artifactId>
	<version>5.3.13.RELEASE</version>
</dependency>

```