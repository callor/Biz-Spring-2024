# Spring 이미지 갤러리 프로젝트
- MySQL, Mybatis, Tiles 를 이용한 갤러리 프로젝트

## 프로젝트 개요
- 이미지 갤러리 프로젝트는 한개의 게시물에 한개의 이미지만 있는 형태로 구현한다.
- 갤러리 작성에서 날짜, 시각, 작성자, 제목, 간략한 소개, 그리고 한개의 이미지를 첨부하여 게시물을 작성한다.
- 작성된 게시물은 tbl_gallerys 에 추가한다.
- 날짜와 시간은 시스템에서 자동으로 생성하고, 작성자는 임의로 입력한다.
- 로그인 기능이 완성되면 로그인한 사용자 username 을 작성자 이름으로 자동 설정한다.
- 이미지를 파일로 저장하지 않고, DB Table 의 한 칼럼으로 저장하는 방법을 시도 해보자

## Tiles 를 이용한 Layout 설정
- dependency 설정
```xml

<properties>
	<org.apache.tiles-version>3.0.8</org.apache.tiles-version>
</properties>

<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-core</artifactId>
    <version>${org.apache.tiles-version}</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-extras</artifactId>
    <version>${org.apache.tiles-version}</version>
</dependency>
```

## `tiles-context.xml` 에 `ViewResolver` 설정
```xml
<bean class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
	<property name="definitions">
		<list>
			<value>/WEB-INF/spring/appServlet/tiles-layout/*-layout.xml</value>
		</list>
	</property>
</bean>
	
<bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">
	<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"/>
	<property name="order" value="1"/>
</bean>
```	
- `layout.xml` 위치 설정
- `order` 값을 반드시 1로 설정

## `*-layout.xml` 에 `ViewResolver`를 받아서 `Rendering` 하는 방법 설정
- `default` definition 설정
- 전체 layout 을 감쌀 box-layout 
- 여기에는 모든 페이지에 공통으로 include 할 파일을 설정해 둔다

```xml
<tiles-definitions>
	<definition name="default" template="/WEB-INF/views/home.jsp">
		<put-attribute name="head" value="/WEB-INF/views/includes/include-head.jsp" />
		<put-attribute name="header" value="/WEB-INF/views/includes/include-header.jsp" />
		<put-attribute name="nav" value="/WEB-INF/views/includes/include-main-nav.jsp" />
	</definition>
```

- `Controller` 에서 `return` 된 문자열을 받아서 처리하는 부분
- `return home` 이 실행되면 다음의 definition 이 응답을 받아서 Rendering 할 준비
- `default` 로 설정된 definition 을 layout 으로 삼아 화면을 구성한다

```xml
<tiles-definitions>
	<!-- Controller 에서 return "home" 이 요청되면 -->
	<definition name="home" extends="default">
		<put-attribute name="content" value="" />
	</definition>
</tiles-definitions>
```

- 다중 경로 Resolver
- 만약 return 값이 `user/login`, `user/join`, `user/mypage` 등과 같이 다중 경로의 Resolver 가 필요한 경우 와일드 카드인 애스터리스크`(*)` 를 사용하여 경로 응답을 받고, include 를 할때 `{1}`,와 같이 위치기호를 사용하여 처리할 수 있다

```xml
<tiles-definitions>
	<definition name="user/*"  extends="default">
		<put-attribute name="content" value="/WEB-INF/views/user/{1}.jsp" />
	</definition>
</tiles-definitions>
```
