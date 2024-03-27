# Di 와 Ioc
- `DI` : Dependency Injection, 의존성주입
- `Ioc` : Inversion Of Control, 제어의 역전

## 표준 Java 코드 : POJO(Plan Old Java Object)
- 표준 Java 코드에서 객체 생성하기
- 표준 Java 코드에서는 클래스를 통하여 객체를 생성하고, 객체로 부터 method, 변수 등에 접근을 한다
- 표준 Java 코드에서는 객체가 필요할때 마다, 그때 그때 객체를 선언하고생성한다.
```java
UserService userService = new UserServiceImpl()
```

## Spring 에서의 Java 코드
- Spring 에서는 일반적으로 사용하는 컴포넌트를 미리 준비해두고, 필요한 곳에 주입하여 사용하는 방식으로 작성한다
- Spring 에서 클래스를 선언하고, 미리 bean 으로 생성해 두는 코드를 마련해 두면, Spring Framework에서 클래스를 미리 객체로 생성하여 Spring Container 에 보관한다.
- 이때 생성되는 객체는 Single Tone 패턴에 의거하여 한개만 생성해 둔다
- 어디선가 객체가 필요한 곳이 있으면, 요청하는 코드를 작성하고 Spring Framework에 의해 미리 준비된 bean 을 주입하는 형태로 코드가 실행된다
- 생성자를 통해서 주입하기, setter 를 통해서 주입하기 등이 사용된다.
- `bean-confiruration.xml` 파일에 `bean` 으로 선언을 해 두면 프로젝트가 시작될때 객체를 생성하고 초기화 하여 `Spring Container` 에 보관해 둔다.
- 그리고 필요한 곳에 자동으로 주입(DI) 한다.
- 표준 Java 와 달리 그때그때 생성하는 코드를 작성하지 않고, 필요한 곳에 주입하는 절차가 진행된다 이것을 `IoC`, `제어의 역전`이라고 한다.
- bean 생성하는 코드 준비
- `c.c.h.service.impl.UserServiceImpl` 클래스를 `userService`라는 이름의 객체(bean)로 준비해 달라 라는 선언
```xml
<bean id="userService" 
		class="com.callor.hello.service.impl.UserServiceImpl"/>
```
```java
// 생성자 주입
private final UserService userService;
public UserController(UserService userService) {
	this.userService = userService;
}

// setter 주입
private UserSerivce userService;
@Autowired
publi void setUserService(UserService userService) {
	this.userService = userService;
}

// 맴버변수 직접 주입방식
@Autowired
private UserService userService;
```