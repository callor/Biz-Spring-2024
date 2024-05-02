# thymeleaf view template
- dependency
```xml
<!-- thymeleaf 는 버전을 일치시키기 위하여 공통 properties 를 선언 -->
<properties>
	<org.thymeleaf-version>3.1.2.RELEASE</org.thymeleaf-version>
</properties>

<!-- thymeleaf 를 사용하기 위한 core lib 가져오기 -->
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring5</artifactId>
	<version>${org.thymeleaf-version}</version>
</dependency>

<!-- spring security 와 연동하기 위한 lib 가져오기 -->
<dependency>
	<groupId>org.thymeleaf.extras</groupId>
	<artifactId>thymeleaf-extras-springsecurity5</artifactId>
	<version>${org.thymeleaf-version}</version>
</dependency>

<!-- thymleaf Layout 구현을 위한 lib 가져오기 -->
<dependency>
	<groupId>nz.net.ultraq.thymeleaf</groupId>
	<artifactId>thymeleaf-layout-dialect</artifactId>
	<version>3.3.0</version>
</dependency>
```

## thymeleaf 기본 사용법
- HTML 코드의 tag 에 속성으로 설정한다
- 속성에 `th:` prefix 로 시작한다
- 정적 web server 를 사용하여 html 파일을 열면 `th:*` 속성은 모두 무시된다.
- thymeleaf 를 사용하면 디자이너와 개발자가보는 화면이 매우 유사하게 작동되어 디자이너와 개발자 간에 협업관계가 매우 좋아진다.
- 모든 속성의 지정은 tag 내에 작성한다 
```html
<div th:text="안녕하세요">안녕하세요</div>

<!-- 반복문도 별도의 block 를 만들지 않고 실제 반복이 이루어질 tag 에 직접 적용 -->
<ul>
  <li th:each=""></li>
</ul>
```

## 자주 사용하는 문법들
### 반복문
- `Controller`에서 `Model`을 통하여 전달받은 `GALLERYS` 리스트를 반복문을 통하여 화면에 그리기
- `GALLERYS` 리스트를 반복(each) 하면가 각각의 요소를 `GA`에 담아 `div` 내부의 요소에 전달한다.
```html
<div class="gallery card" th:each="GA:${GALLERYS}">
	<div th:text="$GA.image_name}">여기는 이미지 이름</div>
</div>
```

### form : 특히 Spring Security 와 연동할때
- html form 을 사용하여 Server 로 `POST method`로 데이터를 전송할때, Spring Security 프로젝트에서는 반드시 `csrf`의 `token`을 함께 서버로 전송해야하는 규칙이 있다.
- 이때 `<input type="hidden">` 과 같은 임의의 tag 를 추가 하는 방법이 있지만 이 방법은 상당히 번거로운 작업이 된다.
- thymeleaf 의 특별한 기능을 활용하여 `token`을 자동 설정하는 방법을 사용한다
- `<form th:action>` 속성을 추가해 주면 thymeleaaf 에 의해 자동으로 `token`이 설정된다.
- 그런데 form 의 action 을 사용하면 반드시 서버의 특정 `RequestMapping`을 설정해주어야 하는데, 입력 form 이 열릴때 사용했던 `URL`을 그대로 적용하고 싶으면 thymeleaf 에서는  
`th:action` 속성 키워드만 사용하고 값을 붙이지 않으면 된다.	

```html
<!-- 특정 URL 을 통하여 서버로 데이터 전송하기 -->
<form method="POST" class="join form" th:action="@{/user/join}">
	<input name="username"/>
</form>

<!-- 현재 화면이 열릴때 사용한 URL 을 action 으로 지정하고 싶을때 -->
<form method="POST" class="join form" th:action>
	<input name="username"/>
</form>
```




