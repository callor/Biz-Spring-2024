# SpringMVC DBMS 연동
- SpringMVC 프로젝트에서 DBMS 를 연동하는 방법은 크게 2가지가 있다. `MyBatis`라는 도구를 사용하여 `SQL` 방식으로 코딩하기와 `JPA(Java Data)`라는 도구를 사용하여 `ORM` 방식으로 코딩하기가 있다
- 근래에 SpringMVC 프로젝트에서 `JPA` 방식의 사용이 점점 증가하고 있지만. 현업실무에서는 아직도 `MyBatis` 방식이 아주 많이 사용되고 있다.

## SpringMVC + MyBatis 연동 프로젝트 구현하기
- 필요한 Dependency 가져오기
- `mybatis`, `mybatis-spring`, `spring-jdbc`, `commons-dbcp2`, `JDBC`
```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.15</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.3</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.12.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>6.1.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
```
- `주의할점` : `spring-jdbc` 는 `spring-webmvc`와 버전을 일치시킬것
